package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro extends SubsystemBase {

  private AHRS ahrs; // consist of sensors on three axes : yaw, roll, pitch
  private static Gyro gyro = null;

  public Gyro() {
    ahrs = new AHRS();
  }

  public static Gyro getInstance() { 
    if (gyro == null) {
      gyro = new Gyro();
    }
    return gyro;
  }

  public void reset() {
    ahrs.reset(); // reset cả 3 trục về 0
  }

  public double getYaw() {
    return ahrs.getYaw(); // return the yaw value that was reported by the sensor (from -180 to 180)
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("X", ahrs.getDisplacementX()); // Liên tục cập nhật giá trị của X lên Dashboard
    SmartDashboard.putNumber("Y", ahrs.getDisplacementY()); // Liên tục cập nhật giá trị của Y lên Dashboard
  }
  
}
