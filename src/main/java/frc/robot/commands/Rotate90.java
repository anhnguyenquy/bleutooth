// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import static frc.robot.RobotContainer.*;
import frc.robot.commands.Stop;
import frc.robot.commands.NewRotate.Direction;

public class Rotate90 extends SequentialCommandGroup {
  public Rotate90() {
    addCommands(
      new NewRotate(drivebase, Direction.RIGHT),
      new WaitCommand(1.5),
      new Stop(drivebase)
    );
  }
}
