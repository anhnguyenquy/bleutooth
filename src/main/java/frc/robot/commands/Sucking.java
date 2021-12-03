// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sucker;

public class Sucking extends CommandBase {
  private Sucker suck1 = new Sucker();
  /** Creates a new Sucking. */
  public Sucking(Sucker suc) {
    suck1 = suc;
    addRequirements(suck1);
    // Use addRequirements() here to declare subsystem dependencies.
  } 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    suck1.speedWheel(); // Run the wheel with given velocity
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    suck1.stop(); // When end, stop the wheel
  }  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
