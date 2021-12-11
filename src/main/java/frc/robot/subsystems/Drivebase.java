package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.*;
import static frc.robot.RobotContainer.*;

public class Drivebase extends SubsystemBase {

  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX rightFollow;
  private WPI_TalonSRX leftFollow;

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

  public void drive(double rightSpeed, double leftSpeed) {
    rightMaster.set(rightSpeed);
    leftMaster.set(leftSpeed);
  }

  @Override
  public void periodic() {
    double leftInput = movementController.getRawAxis(Axis.kLeftY.value);
    double rightInput = movementController.getRawAxis(Axis.kRightY.value);

    if (leftInput * rightInput < 0) {
      leftInput = 0;
      rightInput = 0;
    }

    drive(leftInput * Controllers.sensitivity, rightInput * Controllers.sensitivity);
  }
  
}
