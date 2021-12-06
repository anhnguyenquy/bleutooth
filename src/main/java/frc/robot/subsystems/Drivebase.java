package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.*;

public class Drivebase extends SubsystemBase {

  public WPI_TalonSRX rightMaster;
  public WPI_TalonSRX leftMaster;
  public WPI_TalonSRX rightFollow1;
  public WPI_TalonSRX leftFollow1;
  public WPI_TalonSRX rightFollow2;
  public WPI_TalonSRX leftFollow2;

  public Drivebase() {
    rightMaster = new WPI_TalonSRX(Motors.rightMaster);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    leftMaster = new WPI_TalonSRX(Motors.leftMaster);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftMaster.setInverted(true);

    rightFollow1 = new WPI_TalonSRX(Motors.rightFollow1);
    rightFollow1.setNeutralMode(NeutralMode.Brake);
    rightFollow1.follow(rightMaster);

    leftFollow1 = new WPI_TalonSRX(Motors.leftFollow1);
    leftFollow1.setNeutralMode(NeutralMode.Brake);
    leftFollow1.follow(leftMaster);

    rightFollow2 = new WPI_TalonSRX(Motors.rightFollow2);
    rightFollow2.setNeutralMode(NeutralMode.Brake);
    rightFollow2.follow(rightMaster);

    leftFollow2 = new WPI_TalonSRX(Motors.leftFollow2);
    leftFollow2.setNeutralMode(NeutralMode.Brake);
    leftFollow2.follow(leftMaster);
  }

  public void drive(double rightSpeed, double leftSpeed) {
    rightMaster.set(rightSpeed);
    leftMaster.set(leftSpeed);
  }

  @Override
  public void periodic() {
    double boost = RobotContainer.stick.getRawButton(Buttons.speedUpButton) ? 0.8 : 0.4;

    // Hiểu đơn giản chỗ này là nếu ấn nút lái bên nào thì biến driving bên đó trả
    // về 1 còn ko thì trả về 0
    int drivingRight = RobotContainer.stick.getRawAxis(Buttons.driveRight) > 0 ? 1 : 0;
    int drivingLeft = RobotContainer.stick.getRawAxis(Buttons.driveLeft) > 0 ? 1 : 0;

    drive(drivingRight * boost, drivingLeft * boost);
  }
}
