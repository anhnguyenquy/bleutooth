package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

public class Spinner extends SubsystemBase {
  private WPI_TalonSRX spinner;

  public Spinner() {
    spinner = new WPI_TalonSRX(Motors.spinner);
  }

  public void start(double speed) {
    spinner.set(speed);
  }

  public void stop() {
    spinner.set(0);
  }

  @Override
  public void periodic() {}
}
