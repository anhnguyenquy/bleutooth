// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.TurnController;
//import static frc.robot.Constants.spin.PID.*;

public class RotateAngle extends CommandBase {
  private final Gyro m_gyro;
  private final Drivebase drivebase;
  public TurnController turnController;
  /** Creates a new RotateAngle. */
  
  public RotateAngle(Drivebase dr, double angle) {
    drivebase = dr;
    turnController = TurnController.getInstance();
    m_gyro = Gyro.getInstall();
    
    turnController.setSetPoint(angle);
    turnController.setTolerance();
    turnController.setIntegratorRange(-1, 10);
    turnController.enableContinuousInput(-180, 180);

    addRequirements(drivebase);
    addRequirements(m_gyro);
    addRequirements(turnController);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turnController.reset();
    m_gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { // công thức tính speed
    SmartDashboard.putBoolean("start", true ); // Put a boolean on the table
    SmartDashboard.putNumber("angle", m_gyro.getYaw());
    double speed = turnController.turncontroller.calculate(m_gyro.getYaw());
    speed += Math.signum(speed)*0.1;    // High bound
    speed = Math.min(-0.6, Math.max(0.6, speed));   // Lower bound
    drivebase.drive(speed, speed);
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turnController.atSetpoint();  // return true if the sai so is within 
                                         //the tolerance, nguoc lai thi false
  }
}
