// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class Drive extends CommandBase {
  public Drivebase drift = new Drivebase();
  public double k;
  /** Creates a new DriveStraight. */
  public Drive(Drivebase drove, double j) {
    drift = drove;
    k = j;
    addRequirements(drift);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drift.drive (k, k);
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
