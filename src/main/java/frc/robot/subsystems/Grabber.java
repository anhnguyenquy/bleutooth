package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

public class Grabber extends SubsystemBase {
  private WPI_TalonSRX grabber;

  public Grabber() {
    grabber = new WPI_TalonSRX(Motors.grabber);
  }

  public void start(double speed) {
    grabber.set(speed);
  }

  public void stop() {
    grabber.set(0);
  }

  @Override
  public void periodic() {}
}
