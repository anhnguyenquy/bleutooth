package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.CustomFunctions;

public class Forward extends CommandBase {

  private Drivebase drivebase;
  private double meters;

  public Forward(Drivebase drivebase, double meters) {
    this.drivebase = drivebase;
    this.meters = meters;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    drivebase.drive(Speed.defaultMoveSpeed, Speed.defaultMoveSpeed); // Speed 2 bên đều là v do đi thẳng
    CustomFunctions.setTimeout(() -> end(true), (int) (Time.timeToMove1MeterAtDefaultSpeed * meters));
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
