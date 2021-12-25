package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Drivebase.Direction;

public class GyrolessRotate extends CommandBase {
  private Drivebase m_drivebase;
  private double m_deg;
  private Direction m_dir;
  private boolean hasRotated;

  /** Creates a new GyrolessRotate. */
  public GyrolessRotate(Drivebase drivebase, Direction direction, double degrees) {
    m_drivebase = drivebase;
    m_deg = degrees;
    m_dir = direction;
    hasRotated = false;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivebase.rotate(m_dir, m_deg);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return hasRotated;
  }
}
