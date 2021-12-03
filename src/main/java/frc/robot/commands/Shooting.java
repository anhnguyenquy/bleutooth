// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
public class Shooting extends CommandBase {
  /** Creates a new Shooting. */
  private Shooter shoot = new Shooter();
  private double x;
  public Shooting(Shooter s, double speed) {
    shoot = s;
    x = speed;
    addRequirements(s);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shoot.shooter(x); // Set the speed of the wheel of 2 shooter
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute ( ) {
  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shoot.shooter (0);// return 
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
