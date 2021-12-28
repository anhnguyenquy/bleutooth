package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spinner;

public class MoveSpinner extends CommandBase {

  private Spinner spinner;

  public MoveSpinner(Spinner spinner) {
    this.spinner = spinner;
    addRequirements(this.spinner);
  }

  @Override
  public void initialize() {
    spinner.start(1);
  }

  @Override
  public void execute() {
    
  }

  @Override
  public void end(boolean interrupted) {
    spinner.stop();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
  
}