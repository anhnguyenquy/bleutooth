package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import static frc.robot.CustomFunctions.*;

public class NewRotate extends CommandBase {

  private final Drivebase drivebase;
  private final String direction;

  public NewRotate(Drivebase drivebase, String direction) {
    this.drivebase = drivebase;
    this.direction = direction;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (direction == "right") {
      drivebase.drive(0, 1);
    }
    if (direction == "left") {
      drivebase.drive(1, 0);
    }
  }

  @Override
  public void end(boolean interrupted) {  }

  @Override
  public boolean isFinished() {
    return true;
  }
}