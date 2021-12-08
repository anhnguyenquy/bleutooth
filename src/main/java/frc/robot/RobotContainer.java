package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
  public static final Joystick stick = new Joystick(Constants.Joystick.stickPort);
  public static DriveBase drive = new DriveBase();
  public static Intakers intakers = new Intakers();

  Command auto = new Auto(intakers, drive);
  Command driveStraight = new DriveStraight(drive, 0.3);
  Command rotate = new RotateAngle(drive, stick.getRawAxis(Constants.Joystick.Axes.HIDYawAxis));

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
    new JoystickButton(stick, Constants.Joystick.Buttons.driveStraightBind).whenActive(driveStraight); // Khi ấn nút 1 trên joystick thì bot chạy thẳng
    new JoystickButton(stick, Constants.Joystick.Buttons.rotateBind).whenActive(rotate);
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
