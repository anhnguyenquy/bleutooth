package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.*;
import static frc.robot.RobotContainer.*;

public class DriveManual extends CommandBase {

  private Drivebase drivebase;
  private double baseSpeed = 0;
  private double pivot = 0;
  private double leftMotorInput = 0;
  private double rightMotorInput = 0;

  // Legacy
  private double leftSpeed = 0;
  private double rightSpeed = 0;

  public DriveManual(Drivebase drivebase) {
    this.drivebase = drivebase;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (RobotContainer.useLegacy) {
      double boostLeft = movementController.getRawAxis(2) == 1 ? 1 : 0.4;
      double boostRight = movementController.getRawAxis(4) == 1 ? 1 : 0.4;
      leftSpeed = -movementController.getRawAxis(1) * boostLeft;
      rightSpeed = movementController.getRawAxis(5) * boostRight;
      drivebase.drive(leftSpeed, rightSpeed);
      SmartDashboard.putNumber("Left motor's speed", leftSpeed);
      SmartDashboard.putNumber("Right motor's speed", rightSpeed);
    }

    else {
      baseSpeed = movementController.getRawAxis(1);
      baseSpeed = (Math.abs(baseSpeed) > Controllers.deadzone) ? baseSpeed : 0;

      pivot = movementController.getRawAxis(4);
      pivot = (Math.abs(pivot) > Controllers.deadzone) ? pivot : 0;

      leftMotorInput = baseSpeed;
      rightMotorInput = baseSpeed;

      if (baseSpeed > 0) {
        leftMotorInput += pivot;
        rightMotorInput -= pivot;

        // Enforce safety speed cap
        leftMotorInput = Math.min(Speed.safetyThreshold, leftMotorInput);
        rightMotorInput = Math.min(Speed.safetyThreshold, rightMotorInput);

        // Enable quick turning
        if (leftMotorInput * rightMotorInput <= 0) {
          leftMotorInput = (leftMotorInput <= 0) ? -rightMotorInput : leftMotorInput;
          rightMotorInput = (rightMotorInput <= 0) ? -leftMotorInput : rightMotorInput;
        }
      }

      else if (baseSpeed < 0) {
        leftMotorInput -= pivot;
        rightMotorInput += pivot;

        // Enforce speed safety cap
        leftMotorInput = Math.max(-Speed.safetyThreshold, leftMotorInput);
        rightMotorInput = Math.max(-Speed.safetyThreshold, rightMotorInput);

        // Enable quick turning
        if (leftMotorInput * rightMotorInput <= 0) {
          leftMotorInput = (leftMotorInput >= 0) ? -rightMotorInput : leftMotorInput;
          rightMotorInput = (rightMotorInput >= 0) ? -leftMotorInput : rightMotorInput;
        }
      }

      // For some reason lol
      leftMotorInput = -leftMotorInput;

      // Modeset the motors and output to SmartDashboard
      // Has to be negated for some reason
      drivebase.drive(leftMotorInput, rightMotorInput);
      SmartDashboard.putNumber("Left motor's speed", leftMotorInput);
      SmartDashboard.putNumber("Right motor's speed", rightMotorInput);
    }

    SmartDashboard.putBoolean("Legacy Mode", RobotContainer.useLegacy);
 }

  @Override
  public void end(boolean interrupted) {
    drivebase.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
  
}
