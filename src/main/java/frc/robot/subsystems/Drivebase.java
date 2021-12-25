package frc.robot.subsystems;

// WPILib
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// Vendor libraries
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

// User code
import static frc.robot.Constants.*;

public class Drivebase extends SubsystemBase {
  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX rightFollow;
  private WPI_TalonSRX leftFollow;

  public enum Direction {
    CLOCKWISE,
    COUNTERCLOCKWISE
  }

  public Drivebase() {
    rightMaster = new WPI_TalonSRX(Motors.rightMaster);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    leftMaster = new WPI_TalonSRX(Motors.leftMaster);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setInverted(true);

    rightFollow = new WPI_TalonSRX(Motors.rightFollow);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    rightFollow.follow(rightMaster);

    leftFollow = new WPI_TalonSRX(Motors.leftFollow);
    leftFollow.setNeutralMode(NeutralMode.Brake);
    leftFollow.follow(leftMaster);
  }

  public void drive(double leftSpeed, double rightSpeed) {
    leftMaster.set(leftSpeed);
    rightMaster.set(rightSpeed);
  }

  public void drive(double speed) { // Shorthand function
    leftMaster.set(speed);
    rightMaster.set(speed);
  }

  public void rotate(Direction direction, double magnitude) {
    switch (direction) {
      case CLOCKWISE:
        drive(Speed.safetyThreshold, 0);
      case COUNTERCLOCKWISE:
        drive(0, Speed.safetyThreshold);
    }
    new WaitCommand(Time.clockwise90 / 90 * magnitude);
    drive(0);
  }

  @Override
  public void periodic() {}
}
