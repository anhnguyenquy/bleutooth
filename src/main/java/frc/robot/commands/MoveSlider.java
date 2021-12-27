package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Slider;

public class MoveSlider extends CommandBase {

  private Slider slider;
  private String command;

  public MoveSlider(Slider slider, String command) {
    this.slider = slider;
    this.command = command;
    addRequirements(this.slider);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (command == "start") {
        slider.start(1);
    }
    if (command == "stop") {
        slider.stop();
    }
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return true;
  }
  
}