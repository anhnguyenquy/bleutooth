package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Constants.PID.*;

public class CollisionDetect extends CommandBase {
  public DriveBase driver;
  public Timer time;
  public AHRS sensor;
  public double last_time = 0;
  public double last_world_linear_accel_x = 0;
  public double last_world_linear_accel_y = 0;

  public CollisionDetect(DriveBase DriveBase, AHRS ahrs) {
    driver = DriveBase;
    time = new Timer();
    sensor = ahrs;
    addRequirements(driver);
  }

  @Override
  public void initialize() {
    time.start();

  }

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

      if (delta_time == 1) {
        if ((Math.abs(delta_accel_x) > kCollisionThreshold_DeltaG)
            || (Math.abs(delta_accel_y) > kCollisionThreshold_DeltaG)) {
          collisionDetected = true;
          SmartDashboard.putBoolean("CollisionDetected", collisionDetected);
        }
      }
      last_world_linear_accel_x = curr_world_linear_accel_x;
      curr_world_linear_accel_x = sensor.getWorldLinearAccelX();
      curr_world_linear_accel_y = sensor.getWorldLinearAccelY();
      last_time = current_time;
      current_time = time.get();
    }
  }

  @Override
  public void end(boolean interrupted) {
    driver.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
