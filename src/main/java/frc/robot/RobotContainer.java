package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static frc.robot.Constants.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {

  public static boolean useLegacy = false;
  public static Drivebase drivebase = new Drivebase();
  public static Spinner spinner = new Spinner();
  public static Slider slider = new Slider();
  public static Latch latch = new Latch();
  public static Grabber grabber = new Grabber();
  public static XboxController movementController = new XboxController(Controllers.movementController);
  public static LimitSwitches limitSwitches = new LimitSwitches();
  

  Command driveStraight = new DriveStraight(drivebase, 1);
  Command moveAuto = new MoveAuto(drivebase);
  Command rotate90 = new Rotate90();
  Command moveSpinner = new MoveSpinner(spinner);
  Command moveSlider = new MoveSlider(slider);
  Command extendLatch = new MoveLatch(latch, MoveLatch.Command.EXTEND);
  Command retractLatch = new MoveLatch(latch, MoveLatch.Command.RETRACT);
  Command grabberUp = new Grab(grabber, Grab.Command.UP);
  Command grabberDown = new Grab(grabber, Grab.Command.DOWN);
  Command readDIO = new ReadDIO(limitSwitches);

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
    new JoystickButton(movementController, 5).whileActiveOnce(moveSlider);
    new JoystickButton(movementController, 6).whileActiveOnce(moveSpinner); 
    new JoystickButton(movementController, 7).whenPressed(extendLatch); // left-đóng
    new JoystickButton(movementController, 8).whenPressed(retractLatch); // right-mở
    new JoystickButton(movementController, 3).whileActiveOnce(grabberDown); //B
    new JoystickButton(movementController, 2).whileActiveOnce(grabberUp); //X
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return driveStraight;
  }
 
}
