package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DriveStraight extends CommandBase {

  private DriveBase DriveBase;
  private double v;

  public DriveStraight(DriveBase DriveBase, double v) {
    this.DriveBase = DriveBase;
    this.v = v;
    addRequirements(this.DriveBase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    DriveBase.drive(v, v); // Speed 2 bên đều là v do đi thẳng
  }

  @Override
  public void end(boolean interrupted) {
    DriveBase.drive(0, 0); // Set speed 2 bên về 0 để dừng bot
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
