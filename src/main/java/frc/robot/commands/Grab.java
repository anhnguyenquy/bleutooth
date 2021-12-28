package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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


  public Grab(Grabber grabber, Command command) {
    this.grabber = grabber;
    addRequirements(this.grabber);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
   grabber.start(0.2);	
  }

  @Override
  public void end(boolean interrupted) {
    grabber.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}