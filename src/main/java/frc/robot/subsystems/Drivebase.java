package frc.robot.subsystems;

import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.*;
import static frc.robot.RobotContainer.*;

public class Drivebase extends SubsystemBase {
  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX rightFollow;
  private WPI_TalonSRX leftFollow;

  private double baseSpeed = 0;
  private double pivot = 0;
  private double leftMotorInput = 0;
  private double rightMotorInput = 0;

  // Legacy
  private double leftSpeed = 0;
  private double rightSpeed = 0;

  public Drivebase() {
    rightMaster = new WPI_TalonSRX(Motors.rightMaster);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    leftMaster = new WPI_TalonSRX(Motors.leftMaster);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setInverted(true);

    rightFollow = new WPI_TalonSRX(Motors.rightFollow);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    rightFollow.follow(rightMaster);

    leftFollow = new WPI_TalonSRX(Motors.leftFollow);
    leftFollow.setNeutralMode(NeutralMode.Brake);
    leftFollow.follow(leftMaster);
  }

  public void drive(double leftSpeed, double rightSpeed) { 
    leftMaster.set(leftSpeed);
    rightMaster.set(rightSpeed);
  }

  @Override
  public void periodic() {
    
  }
}
