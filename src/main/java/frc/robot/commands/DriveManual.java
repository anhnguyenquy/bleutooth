package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.*;
import static frc.robot.RobotContainer.*;

public class DriveManual extends CommandBase {

  private Drivebase drivebase;

  public DriveManual(Drivebase drivebase) {
    this.drivebase = drivebase;
    addRequirements(this.drivebase);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {
    drivebase.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
