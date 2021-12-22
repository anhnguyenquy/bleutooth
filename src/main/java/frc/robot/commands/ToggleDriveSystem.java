package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ToggleDriveSystem extends CommandBase {

  public ToggleDriveSystem() {

  }

  @Override
  public void initialize() {
    RobotContainer.useLegacy = !RobotContainer.useLegacy;
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
