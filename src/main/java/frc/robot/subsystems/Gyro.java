// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Gyro extends SubsystemBase {
  private AHRS ahrs; // consist of sensors on three axis : yaw, roll, pitch
  /** Creates a new Gyro. */
  public Gyro() {
    ahrs = new AHRS();
  }

  private static Gyro gyro = null; 
  public static Gyro getInstanceGyro (){ 
    if (gyro == null) {
      gyro = new Gyro();
    }
    return gyro;
  }
  
  public void reset(){
    ahrs.reset(); // reset the yaw to zero
  }

  public double getYaw(){
    return ahrs.getYaw(); // return the yaw value that was report by the sensor (from -180 to 180) 
  }
  public double getWorldLinearAccelX(){
    return ahrs.getWorldLinearAccelX();
  }
  public double getWorldLinearAccelY(){
    return ahrs.getWorldLinearAccelY();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("X",ahrs.getDisplacementX()); // Liên tục cập nhật giá trị của x trên Dashboard
    SmartDashboard.putNumber("y",ahrs.getDisplacementY()); // Liên tục cập nhật giá trị của y trên Dashboard
}
}
