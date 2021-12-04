// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Constants.PID.*;

public class CollisionDetect extends CommandBase {
  public Drivebase driver;
  public Timer time;
  public AHRS sensor;
  public double last_time = 0;
  public double last_world_linear_accel_x = 0;
  public double last_world_linear_accel_y = 0;
  /** Creates a new CollisionDeteting. */
  public CollisionDetect(Drivebase drivebase, AHRS ahrs) {
    driver = drivebase;
    time = new Timer();
    sensor = ahrs;
    addRequirements(driver);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.123
  @Override
  public void initialize() {
    time.start();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double current_time = time.get();
    double curr_world_linear_accel_x = sensor.getWorldLinearAccelX();
    double curr_world_linear_accel_y = sensor.getWorldLinearAccelY();
    while (current_time <= 30) {
      boolean collisionDetected = false;

      double delta_time = current_time - last_time;
      double delta_accel_x = curr_world_linear_accel_x - last_world_linear_accel_x;
      double delta_accel_y = curr_world_linear_accel_y - last_world_linear_accel_y;

      if (delta_time == 1){
        if ( ( Math.abs(delta_accel_x) > kCollisionThreshold_DeltaG ) || ( Math.abs(delta_accel_y) > kCollisionThreshold_DeltaG) )  {
          collisionDetected = true;
          SmartDashboard.putBoolean(  "CollisionDetected", collisionDetected);
    }
  }
      last_world_linear_accel_x = curr_world_linear_accel_x;
      curr_world_linear_accel_x = sensor.getWorldLinearAccelX();
      curr_world_linear_accel_y = sensor.getWorldLinearAccelY();
      last_time = current_time;
      current_time = time.get();
}
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driver.drive(0, 0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
