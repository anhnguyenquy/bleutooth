package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import static frc.robot.CustomFunctions.*;

public class NewRotate extends CommandBase {

  public enum Direction {
    RIGHT,
    LEFT
  }
  private final Drivebase drivebase;
  private final Direction direction;

  public NewRotate(Drivebase drivebase, Direction direction) {
    this.drivebase = drivebase;
    this.direction = direction;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    switch (direction) {
      case RIGHT:
        drivebase.drive(0, 1);
        break;
      case LEFT:
        drivebase.drive(1, 0);
        break;
      default:
       // can't reach this
    }
  }

  @Override
  public void end(boolean interrupted) {  }

  @Override
  public boolean isFinished() {
    return false;
  }
}