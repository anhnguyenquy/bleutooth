package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class DriveStraight extends CommandBase {

  private Drivebase drivebase;
  private double v;

  public DriveStraight(Drivebase drivebase, double v) {
    this.drivebase = drivebase;
    this.v = v;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    drivebase.drive(v, v);
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
