package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Slider;

public class MoveSlider extends CommandBase {

  private Slider slider;

  public MoveSlider(Slider slider) {
    this.slider = slider;
    addRequirements(this.slider);
  }

  @Override
  public void initialize() {
    slider.start(-1);
  }

  @Override
  public void execute() {
    
  }

  @Override
  public void end(boolean interrupted)  {
    slider.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}