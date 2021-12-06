package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

public class Intakers extends SubsystemBase {

  public WPI_TalonSRX intaker1;
  public WPI_TalonSRX intaker2;
  public WPI_TalonSRX intaker3;

  public Intakers() {
    intaker1 = new WPI_TalonSRX(Motors.intaker1);
    intaker2 = new WPI_TalonSRX(Motors.intaker2);
    intaker3 = new WPI_TalonSRX(Motors.intaker3);
  }

  public void start() {
    intaker1.set(Speed.speed1);
    intaker2.set(-Speed.speed1);
    intaker3.set(Speed.speed1);
  }

  public void stop() {
    intaker1.set(0);
    intaker2.set(0);
    intaker3.set(0);
  }

  @Override
  public void periodic() {

  }
}
