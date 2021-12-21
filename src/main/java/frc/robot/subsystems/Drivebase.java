package frc.robot.subsystems;

import java.lang.Math;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
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
    /* Legacy manual drive
    double boostLeft = movementController.getRawAxis(2) == 1 ? 1 : 0.4;
    double boostRight = movementController.getRawAxis(4) == 1 ? 1 : 0.4;
    drive(-movementController.getRawAxis(1) * boostLeft, movementController.getRawAxis(5) * boostRight);
    */

    baseSpeed = movementController.getRawAxis(Axis.kLeftY.value);
    baseSpeed = (Math.abs(baseSpeed) > Controllers.deadzone) ? baseSpeed : 0;

    pivot = movementController.getRawAxis(Axis.kRightX.value);
    pivot = (Math.abs(pivot) > Controllers.deadzone) ? pivot : 0;

    leftMotorInput = baseSpeed;
    rightMotorInput = baseSpeed;

    if (baseSpeed > 0) {
      leftMotorInput += pivot;
      rightMotorInput -= pivot;

      // Enforce safety speed cap
      leftMotorInput = Math.min(Speed.safetyThreshold, leftMotorInput);
      rightMotorInput = Math.min(Speed.safetyThreshold, rightMotorInput);

      // Experimental quick turning patch
      if (leftMotorInput * rightMotorInput < 0) {
        leftMotorInput = (leftMotorInput < 0) ? -rightMotorInput : leftMotorInput;
        rightMotorInput = (rightMotorInput < 0) ? -leftMotorInput : rightMotorInput;
      }
    }

    else if (baseSpeed < 0) {
      leftMotorInput -= pivot;
      rightMotorInput += pivot;

      // Enforce speed safety cap
      leftMotorInput = Math.max(-Speed.safetyThreshold, leftMotorInput);
      rightMotorInput = Math.max(-Speed.safetyThreshold, rightMotorInput);

      // Experimental quick turning patch
      if (leftMotorInput * rightMotorInput < 0) {
        leftMotorInput = (leftMotorInput > 0) ? -rightMotorInput : leftMotorInput;
        rightMotorInput = (rightMotorInput > 0)? -leftMotorInput : rightMotorInput;
      }
    }

    // Modeset the motors
    // Has to be negated for some reason
    drive(-leftMotorInput, -rightMotorInput);
  }
}
