package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.RobotContainer.*;

import static frc.robot.Constants.*;

public class LimitSwitches extends SubsystemBase {

  public DigitalInput upperLimitSwitchInput;
  public DigitalInput lowerLimitSwitchInput;

  public LimitSwitches() {
    upperLimitSwitchInput = new DigitalInput(DIO.upper);
    lowerLimitSwitchInput = new DigitalInput(DIO.lower);
  }

  public boolean reachedUpperLimit() {
    return !upperLimitSwitchInput.get();
  }

  public boolean reachedLowerLimit() {
    return !lowerLimitSwitchInput.get();
  }

  @Override
  public void periodic() {
    if (!limitSwitches.reachedUpperLimit()) {
      grabber.stop();
    }
    if (!limitSwitches.reachedLowerLimit()) {
      grabber.stop();
      latch.extend();
    }
  }
}