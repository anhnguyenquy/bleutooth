package frc.robot.commands;

// Java
import java.lang.Math;

// WPILib
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// User code
import frc.robot.subsystems.Drivebase;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class DriveManual extends CommandBase {

  private Drivebase drivebase;

  public DriveManual(Drivebase drivebase) {
    this.drivebase = drivebase;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
    drivebase.drive(0);
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("Legacy Mode ", RobotContainer.useLegacy);

    if (RobotContainer.useLegacy) {
      SmartDashboard.delete("Left Motor ");
      SmartDashboard.delete("Right Motor ");

      double leftInput = RobotContainer.movementController.getRawAxis(2) == 1 ? 1 : Constants.Speed.safetyThreshold;
      leftInput *= -RobotContainer.movementController.getRawAxis(1);

      double rightInput = RobotContainer.movementController.getRawAxis(3) == 1 ? 1 : Constants.Speed.safetyThreshold;
      rightInput *= RobotContainer.movementController.getRawAxis(5);

      SmartDashboard.putNumber("[LEGACY] Left Motor ", leftInput);
      SmartDashboard.putNumber("[LEGACY] Right Motor ", rightInput);

      drivebase.drive(leftInput, rightInput);
    }

    else {
      SmartDashboard.delete("[LEGACY] Left Motor ");
      SmartDashboard.delete("[LEGACY] Right Motor ");

      double baseSpeed = RobotContainer.movementController.getRawAxis(1);
      baseSpeed = (Math.abs(baseSpeed) > Constants.Controllers.deadzone) ? baseSpeed : 0;

      double pivot = RobotContainer.movementController.getRawAxis(4);
      pivot = (Math.abs(pivot) > Constants.Controllers.deadzone) ? pivot : 0;

      double leftInput = baseSpeed, rightInput = baseSpeed;

      if (baseSpeed < 0) { // Goes forward
        leftInput -= pivot; rightInput += pivot;

        // Speed cap
        leftInput = Math.max(-Constants.Speed.safetyThreshold, leftInput);
        rightInput = Math.max(-Constants.Speed.safetyThreshold, rightInput);

        // Quick turning
        if (leftInput * rightInput <= 0) {
          leftInput = (leftInput >= 0) ? -rightInput : leftInput;
          rightInput = (rightInput >= 0) ? -leftInput : rightInput;
        }
      }

      else if (baseSpeed > 0) {
        leftInput += pivot; rightInput -= pivot;

        // Speed cap
        leftInput = Math.min(Constants.Speed.safetyThreshold, leftInput);
        rightInput = Math.min(Constants.Speed.safetyThreshold, rightInput);

        // Quick turning
        if (leftInput * rightInput <= 0) {
          leftInput = (leftInput <= 0) ? -rightInput : leftInput;
          rightInput = (rightInput <= 0) ? -leftInput : rightInput;
        }
      }

      // Output to SmartDashboard
      SmartDashboard.putNumber("Left Motor ", leftInput);
      SmartDashboard.putNumber("Right Motor ", rightInput);

      // Modeset the motors
      drivebase.drive(leftInput, rightInput);
    }
  }

  @Override
  public void end(boolean interrupted) {
    drivebase.drive(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}
