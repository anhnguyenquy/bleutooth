package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static frc.robot.Constants.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import static frc.robot.CustomFunctions.*;

public class RobotContainer {

  public static boolean useLegacy = false;
  public static Drivebase drivebase = new Drivebase();
  public static Spinner spinner = new Spinner();
  public static Slider slider = new Slider();
  public static XboxController movementController = new XboxController(Controllers.movementController);

  Command driveManual = new DriveManual(drivebase);
  Command toggleDriveSystem = new ToggleDriveSystem();
  Command moveAuto = new MoveAuto(drivebase);
  Command rotate90 = new Rotate90();
  Command startSpinner = new MoveSpinner(spinner, "start");
  Command startSlider = new MoveSlider(slider, "start");
  Command stopSpinner = new MoveSpinner(spinner, "stop");
  Command stopSlider = new MoveSlider(slider, "stop");


  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(movementController, Controllers.driveSwapButton).whileActiveOnce(toggleDriveSystem);
    new JoystickButton(movementController, 3).whileActiveOnce(startSpinner);
    new JoystickButton(movementController, 2).whileActiveOnce(stopSpinner);
    new JoystickButton(movementController, 5).whileActiveOnce(startSlider);
    new JoystickButton(movementController, 6).whileActiveOnce(stopSlider);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return rotate90;
  }
  public Command getTeleCommand() {
    return driveManual;
  }

}
