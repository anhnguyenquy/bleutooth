package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spinner;

public class MoveSpinner extends CommandBase {

  private Spinner spinner;
  private String command;

  public MoveSpinner(Spinner spinner, String command) {
    this.spinner = spinner;
    this.command = command;
    addRequirements(this.spinner);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (command == "start") {
        spinner.start(1);
    }
    if (command == "stop") {
        spinner.stop();
    }
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return true;
  }
  
}