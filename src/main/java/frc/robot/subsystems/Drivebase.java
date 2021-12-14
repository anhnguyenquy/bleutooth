// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.spin.*;
//import static frc.robot.Constants.joystick.*;

public class DriveBase extends SubsystemBase {
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(Rightmaster);
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(Leftmaster);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(Rightfollow);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(Leftfollow);

  /** Creates a new Drivebase. */
  public DriveBase() {
    rightMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    leftFollow.setNeutralMode(NeutralMode.Brake);

    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
    rightMaster.setInverted(true); // Set the motor quay ngược lại
    rightFollow.setInverted(true); // Set the motor quay ngược lại
  }

  public void drive(double rightmaster, double leftmaster) {
    rightMaster.set(rightmaster);
    leftMaster.set(leftmaster);
  }

  //public double rawAxis(double y) {
  //  return (RobotContainer.stic.getRawAxis(stick) * y);
  //}

  public void Drive(double rightmaster, double leftmaster) { // Another way to express the velocity in frequency
    rightMaster.set(ControlMode.Velocity, rightmaster); // set the setpoint for wheel
    leftMaster.set(ControlMode.Velocity, leftmaster);
  }

  public double PID() {
    rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    double v = (rightMaster.getSelectedSensorPosition() + leftMaster.getSelectedSensorPosition())/2;
    return v;
  }
  
  @Override
  public void periodic() {
    //double x = RobotContainer.stic.getRawButton(8)? 0.5: 0.2;
    //drive (rawAxis(x), rawAxis(x));

    // This method will be called once per scheduler run
  }
}
