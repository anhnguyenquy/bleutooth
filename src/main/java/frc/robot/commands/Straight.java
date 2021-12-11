// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Constants.PID.*;

// A way to pid the drive straight using encoder and pid controller
public class Straight extends CommandBase {
  private DriveBase drive = new DriveBase();
  private PIDController pid; 
  /** Creates a new Straight. */
  public Straight(DriveBase drove,double setPoint) {
    drive = drove;
    pid = new PIDController(kP,kI,kD); // create a new pid controller with three constant
    pid.setSetpoint(setPoint); // set the setpoint
    pid.setTolerance(kToleranceStraight); // set the tolerance
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Auto start"); // start the auto 
    pid.reset(); // reset the pid
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double velocity = pid.calculate(drive.PID()); // calculate the velocity to achieve the goal
    drive.drive(velocity,velocity); // set the velocity
    SmartDashboard.putNumber("Current velocity",velocity); // put the velocity
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.drive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
