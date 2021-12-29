package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spinner;

public class MoveSpinner extends CommandBase {

  private final Spinner spinner;

  public MoveSpinner(Spinner spinner) {
    this.spinner = spinner;
    addRequirements(this.spinner);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    spinner.start(-0.5);
  }

  @Override
  public void end(boolean interrupted) {
    spinner.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}