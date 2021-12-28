package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class LimitSwitches extends SubsystemBase {

  public DigitalInput upperLimitSwitchInput;
  public DigitalInput lowerLimitSwitchInput;

  public LimitSwitches() {
    // upperLimitSwitchInput = new DigitalInput(DIO.upper);
    // lowerLimitSwitchInput = new DigitalInput(DIO.lower);
    upperLimitSwitchInput = new DigitalInput(0);
    lowerLimitSwitchInput = new DigitalInput(1);
  }

  public boolean reachedUpperLimit() {
    return upperLimitSwitchInput.get();
  }

  public boolean reachedLowerLimit() {
    return lowerLimitSwitchInput.get();
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Reached Upper Limit", reachedUpperLimit());
		SmartDashboard.putBoolean("Reached Lower Limit", reachedLowerLimit());
  }
}