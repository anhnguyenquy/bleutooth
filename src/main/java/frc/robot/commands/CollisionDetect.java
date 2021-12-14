// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gyro;
import static frc.robot.Constants.PID.*;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import static frc.robot.Constants.PID.*;

public class CollisionDetect extends CommandBase {
  public Gyro sensor;
  private double last_time = 0;
  private double current_time;
  private double last_world_linear_accel_x = 0;
  private double last_world_linear_accel_y = 0;
  public Timer time;
  public boolean collisionDetected = false;
  /** Creates a new CollisionDeteting. */
  public CollisionDetect(Gyro ahrs) {
    time = new Timer();
    sensor = ahrs;
    addRequirements(sensor);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.123
  @Override
  public void initialize() {
    //time.reset();
    sensor.reset();
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // First, to ensure that robot didn't collide anything
    current_time = time.get(); // take the current time from the timer
    double curr_world_linear_accel_x = sensor.getWorldLinearAccelX(); // lấy thông số gia tốc theo phương x từ sensor
    double curr_world_linear_accel_y = sensor.getWorldLinearAccelY(); // Lấy thông số gia tốc theo phương y từ sensor
    //while (current_time <= 30) { 
        
    double delta_time = current_time - last_time; // Độ chênh lệch thời gian = thời gian hiện tại - cũ
    double delta_accel_x = curr_world_linear_accel_x - last_world_linear_accel_x; // Độ chênh lệch gia tốc
    double delta_accel_y = curr_world_linear_accel_y - last_world_linear_accel_y;
  
    if (delta_time == 1){
      if ( ( Math.abs(delta_accel_x) > kCollisionThreshold_DeltaG ) || ( Math.abs(delta_accel_y) > kCollisionThreshold_DeltaG) )  {
        collisionDetected = true;
        SmartDashboard.putBoolean("CollisionDetected", collisionDetected); // nếu một trong 2 độ biến thiên gia tốc lớn hơn 1 
                                                                                //hằng số xác định thì tính là va chạm
      }
    }
    last_world_linear_accel_x = curr_world_linear_accel_x;
    curr_world_linear_accel_x = sensor.getWorldLinearAccelX();
    curr_world_linear_accel_y = sensor.getWorldLinearAccelY();
    last_time = current_time;
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
}
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return collisionDetected = true;
  }
}
