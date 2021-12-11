package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

public class Intakers extends SubsystemBase {

  private WPI_TalonSRX intaker1;
  private WPI_TalonSRX intaker2;
  private WPI_TalonSRX intaker3;

  public Intakers() {
    intaker1 = new WPI_TalonSRX(Motors.intaker1);
    intaker2 = new WPI_TalonSRX(Motors.intaker2);
    intaker3 = new WPI_TalonSRX(Motors.intaker3);
  }

  public void start() {
    intaker1.set(Speed.defaultIntakerSpeed);
    intaker2.set(-Speed.defaultIntakerSpeed);
    intaker3.set(Speed.defaultIntakerSpeed);
  }

  public void stop() {
    intaker1.set(0);
    intaker2.set(0);
    intaker3.set(0);
  }

  public void startIntaker1Normal() {
    intaker1.set(Speed.defaultIntakerSpeed);
  }
  public void startIntaker1Reverse() {
    intaker1.set(-Speed.defaultIntakerSpeed);
  }
  public void stopIntaker1() {
    intaker1.set(0);
  }

  public void startIntaker2Normal() {
    intaker2.set(Speed.defaultIntakerSpeed);
  }
  public void startIntaker2Reverse() {
    intaker2.set(-Speed.defaultIntakerSpeed);
  }
  public void stopIntaker2() {
    intaker2.set(0);
  }

  public void startIntaker3Normal() {
    intaker3.set(Speed.defaultIntakerSpeed);
  }
  public void startIntaker3Reverse() {
    intaker3.set(-Speed.defaultIntakerSpeed);
  }
  public void stopIntaker3() {
    intaker3.set(0);
  }

  @Override
  public void periodic() {

  }
  
}
