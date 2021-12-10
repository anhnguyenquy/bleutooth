// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.TurnController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Constants.PID.*;

// A second way to pid the drive straight using ahrs
public class GoStraight extends CommandBase {
  private DriveBase drive = new DriveBase();
  private Gyro gyro = new Gyro();
  private TurnController turnController = new TurnController();
  public double angle;
  public double speed;

  /** Creates a new DriveStraight. */
  public GoStraight(DriveBase dr, Gyro gyr, TurnController tController, double ang, double v) {
    drive = dr;
    gyro = gyr;
    turnController = tController;
    angle = ang;
    speed = v;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
    addRequirements(gyro);
    addRequirements(turnController);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turnController.reset();
    gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double curr_angle = gyro.getYaw();
    double error = curr_angle * kStraightConstant;
    SmartDashboard.putNumber("Angle", curr_angle);
    SmartDashboard.putNumber("error", error);
    drive.drive(speed - error, speed + error);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
