// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//package frc.robot.subsystems;

//import edu.wpi.first.wpilibj2.command.SubsystemBase;

//public class TestDrivebase extends SubsystemBase {
  /** Creates a new TestDrivebase. */
  //public TestDrivebase() {}

  //@Override
  //public void periodic() {
    // This method will be called once per scheduler run
  //}
//}
package frc.robot.subsystems;

//import static frc.robot.Constants.STICK_CONST.*;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.sql.Time;

import static frc.robot.Constants.DRIVE_CONST.*;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TestDrivebase extends SubsystemBase {

  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFT_MASTER_CAN); // 7
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHT_MASTER_CAN); // 5
  public WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFT_FOLLOW_CAN); // 3
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHT_FOLLOW_CAN); // 11
  // public boolean enabled = false;
  // public FileOutputStream writer;

  public TestDrivebase() {

    leftFollow.follow(leftMaster);
    leftFollow.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    rightFollow.follow(rightMaster);
    leftMaster.setInverted(true);
    leftFollow.setInverted(true);
    a = leftMaster.getSensorCollection().getQuadraturePosition() / 4096;
    b = rightMaster.getSensorCollection().getQuadraturePosition() / 4096;
  }

  // ByteBuffer buffer = ByteBuffer.allocate(16);

  public void drive(double... v) {
    // if (writer != null) {
    // try {
    // buffer.putDouble(0, v[0]);
    // buffer.putDouble(8, v[1]);
    // writer.write(buffer.array());
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    leftMaster.set(v[0]);
    rightMaster.set(v[1]);
  }

  private double x;
  private double y;
  private double z;
  private double a;
  private double b;

  public double DistanceL() {
    return leftMaster.getSensorCollection().getQuadraturePosition() / 4096.0;
  }

  public double DistanceR() {
    return rightMaster.getSensorCollection().getQuadraturePosition() / 4096.0;
  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("distL", leftMaster.getSensorCollection().getQuadraturePosition() / 4096.0 - a);
    SmartDashboard.putNumber("distR", rightMaster.getSensorCollection().getQuadraturePosition() / 4096.0 - b);

    if (RobotContainer.logitech.getRawAxis(2) > 0.5 && RobotContainer.logitech.getRawAxis(3) > 0.5) {
      drive(RobotContainer.logitech.getRawAxis(1) * 0.8, RobotContainer.logitech.getRawAxis(5) * 0.8);

    } else if (RobotContainer.logitech.getRawAxis(2) > 0.5) {
      SmartDashboard.putBoolean("turning left", true);
      drive(RobotContainer.logitech.getRawAxis(1) * 0.2, RobotContainer.logitech.getRawAxis(5) * 01);
    } else if (RobotContainer.logitech.getRawAxis(3) > 0.5) {
      SmartDashboard.putBoolean("turning right", true);
      drive(RobotContainer.logitech.getRawAxis(1) * 1, RobotContainer.logitech.getRawAxis(5) * 0.2

      );
    } else {
      SmartDashboard.putBoolean("turning left", false);
      SmartDashboard.putBoolean("turning right", false);
      drive(RobotContainer.logitech.getRawAxis(1) * 1, RobotContainer.logitech.getRawAxis(5) * 1);
    }
    if (Math.abs(RobotContainer.logitech.getRawAxis(1)) > 0.5
        && Math.abs(RobotContainer.logitech.getRawAxis(5)) > 0.5) {
      SmartDashboard.putBoolean("driving", true);
      x = Timer.getFPGATimestamp();
      SmartDashboard.putNumber("run time", x - y);
      z = x - y;
      if (z > 6) {
        SmartDashboard.putNumber("stop time", z);
      }
    } else {
      SmartDashboard.putBoolean("driving", false);
      y = Timer.getFPGATimestamp();
    }
  }

}