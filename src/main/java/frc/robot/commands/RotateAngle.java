package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurnController;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Gyro;

public class RotateAngle extends CommandBase {

  private final DriveBase m_drivebase;
  private final Gyro m_gyro;
  public TurnController turnController;

  public RotateAngle(DriveBase drivebase, double angle) {
    m_drivebase = drivebase;
    m_gyro = Gyro.getInstance();
    turnController = new TurnController();
    turnController.setSetPoint(angle);
    turnController.enableContinuousInput(-180, 180); // quay liên tục giữa -180 và 180 độ để đảm bảo gần vs setpoint nhất có thể
    turnController.setIntegratorRange(-10, 1); // set range kI từ -10 đến 1
    turnController.setTolerance();
    addRequirements(m_drivebase);
    addRequirements(m_gyro);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("start", true);
    SmartDashboard.putNumber("angle", m_gyro.getYaw());
    double speed = turnController.calculate(m_gyro.getYaw());
    speed += Math.signum(speed) * 0.1;
    speed = Math.min(0.6, Math.max(-0.6, speed));
    m_drivebase.drive(-speed, speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_drivebase.drive(0, 0);
    SmartDashboard.putBoolean("start", false);
  }

  @Override
  public boolean isFinished() {
    return turnController.atSetpoint();
  }
}
