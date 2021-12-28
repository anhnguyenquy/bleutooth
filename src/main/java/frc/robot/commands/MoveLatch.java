package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Latch;

public class MoveLatch extends CommandBase {

	public enum Command {
		EXTEND,
		RETRACT
	}

  private Latch latch;
	private Command command;

  public MoveLatch(Latch latch, Command command) {
    this.latch = latch;
    this.command = command;
    addRequirements(this.latch);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    switch (command) {
			case EXTEND:
				latch.extend();
				break;
			case RETRACT:
				latch.retract();
				break;
			default:
				// can't hit default
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