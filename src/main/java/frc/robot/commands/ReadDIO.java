package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import static frc.robot.RobotContainer.*;
import static frc.robot.Constants.*;


public class ReadDIO extends CommandBase {

  private LimitSwitches limitSwitches;

  public ReadDIO(LimitSwitches limitSwitches) {
		this.limitSwitches = limitSwitches;
    addRequirements(this.limitSwitches);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
		SmartDashboard.putBoolean("Reached Upper Limit", limitSwitches.reachedUpperLimit());
		SmartDashboard.putBoolean("Reached Lower Limit", limitSwitches.reachedLowerLimit());
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}