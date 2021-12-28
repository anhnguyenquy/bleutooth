package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class LimitSwitches extends SubsystemBase {

  private DigitalInput upperLimitSwitchInput;
  private DigitalInput lowerLimitSwitchInput;

  public LimitSwitches() {
    upperLimitSwitchInput = new DigitalInput(DIO.upper);
    lowerLimitSwitchInput = new DigitalInput(DIO.lower);
  }

  public boolean reachedUpperLimit() {
    return upperLimitSwitchInput.get();
  } 

  public boolean reachedLowerLimit() {
    return lowerLimitSwitchInput.get();
  } 

  @Override
  public void periodic() {}
}