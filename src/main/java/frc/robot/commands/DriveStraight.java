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
    drivebase.drive(v, v); // Speed 2 bên đều là v do đi thẳng
  }

  @Override
  public void end(boolean interrupted) {
    drivebase.drive(0, 0); // Set speed 2 bên về 0 để dừng bot
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
