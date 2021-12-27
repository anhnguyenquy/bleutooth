package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

public class Slider extends SubsystemBase {
  private WPI_TalonSRX slider;

  public Slider() {
    slider = new WPI_TalonSRX(Motors.slider);
  }

  public void start(double speed) {
    slider.set(speed);
  }

  public void stop() {
    slider.set(0);
  }

  @Override
  public void periodic() {}
}