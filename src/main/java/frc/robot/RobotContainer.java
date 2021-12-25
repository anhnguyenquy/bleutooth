package frc.robot;

// WPILib
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// User code
import static frc.robot.Constants.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.Drivebase.Direction;

public class RobotContainer {

  public static Drivebase drivebase = new Drivebase();
  public static XboxController movementController = new XboxController(Controllers.movementController);

  public static boolean useLegacy = false;

  // public static Intakers intakers = new Intakers();
  // Command auto = new Auto(intakers, drive);
  Command driveManual = new DriveManual(drivebase);
  Command toggleDriveSystem = new ToggleDriveSystem();
  Command turnBack = new GyrolessRotate(drivebase, Direction.CLOCKWISE, 180);
  Command moveAuto = new MoveAuto(drivebase);

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
    new JoystickButton(movementController, Controllers.turnBackButton).whileActiveOnce(turnBack);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return moveAuto;
  }

  public Command getTeleCommand() {
    return driveManual;
  }
}
