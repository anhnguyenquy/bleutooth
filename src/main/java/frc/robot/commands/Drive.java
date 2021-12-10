// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBase;
import static frc.robot.Constants.speed.*;


public class Drive extends CommandBase {
  public DriveBase drift = new DriveBase();

  /** Creates a new DriveStraight. */
  // To control the speed by hand
  public Drive(DriveBase drove) {
    drift = drove;
    addRequirements(drift);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double k = RobotContainer.stick.getZ()*maxSpeed; // A way to control the speed, since the z stick only runs from -1 to 1, to go straight
    double j = RobotContainer.stick.getY()*maxSpeed; // A way to control the speed, to turn left or right
    drift.drive(k + j, k - j);
    SmartDashboard.putNumber("CurrentLeftVelocity", k + j); // put the right wheel speed on dashboard
    SmartDashboard.putNumber("CurrentRightVelocity", k -j); // put the left wheel speed on dashboard

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drift.drive (0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
