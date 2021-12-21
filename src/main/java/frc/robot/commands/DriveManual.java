package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class DriveManual extends CommandBase {

  private Drivebase drivebase;

  public DriveManual(Drivebase drivebase) {
    this.drivebase = drivebase;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

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
