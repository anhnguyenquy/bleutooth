package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intakers;

public class Suck extends CommandBase {
  private Intakers intakers = new Intakers();

  public Suck(Intakers intakers) {
    this.intakers = intakers;
    addRequirements(this.intakers);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    intakers.start();
  }

  @Override
  public void end(boolean interrupted) {
    intakers.stop();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
