package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import static frc.robot.Constants.Joysticks;

public class RobotContainer {

  public static final Joystick driveStick = new Joystick(Joysticks.driveStick);
  public static final Joystick turnStick = new Joystick(Joysticks.turnStick);
  private static DriveBase drive = new DriveBase();
  private static Intakers intakers = new Intakers();

  private Command auto = new Auto(intakers, drive);
  private Command driveStraight = new DriveStraight(drive, 0.3);
  private Command rotate = new RotateAngle(drive, turnStick.getRawAxis(Joysticks.Axes.xAxis));

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
    new JoystickButton(driveStick, Joysticks.Buttons.driveStraightBind).whileActiveOnce(driveStraight); // Khi ấn nút 1 trên joystick thì bot chạy thẳng
    new JoystickButton(turnStick, Joysticks.Buttons.turnBind).whileActiveOnce(rotate);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return auto;
  }
}
