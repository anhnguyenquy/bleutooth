package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import static frc.robot.RobotContainer.*;
import static frc.robot.Constants.*;


public class Grab extends CommandBase {

	public enum Command {
		UP,
		DOWN
	}

  private Grabber grabber;
	private Command command;

  public Grab(Grabber grabber, Command command) {
    this.grabber = grabber;
    this.command = command;
    addRequirements(this.grabber);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
		switch (command) {
			case UP:
				if (!limitSwitches.reachedUpperLimit()) {
					grabber.start(Speed.grabberSpeed);
				}
				break;
			case DOWN:
				grabber.start(-Speed.grabberSpeed);
				break;
			default:
				// can't hit this
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