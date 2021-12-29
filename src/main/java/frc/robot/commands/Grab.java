package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import static frc.robot.RobotContainer.*;
import static frc.robot.Constants.*;

public class Grab extends CommandBase {

  public enum Command {
    UP, DOWN
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
        // if (!limitSwitches.reachedUpperLimit()) {
        //   latch.retract();
        //   grabber.start(Speed.grabberSpeed);
        // }
        grabber.start(Speed.grabberSpeed);
        break;
      case DOWN:
        // if (!limitSwitches.reachedLowerLimit()) {
        //   grabber.start(-Speed.grabberSpeed);
        // }
        grabber.start(-Speed.grabberSpeed);
        break;
      default:
        // can't reach this
    }
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