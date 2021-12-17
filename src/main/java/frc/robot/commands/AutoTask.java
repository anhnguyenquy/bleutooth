// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Gyro;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Autotask extends SequentialCommandGroup {
  /** Creates a new Autotask. */
  public Autotask(DriveBase drive,Gyro ahrs,double setPoint,double set_Point) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new RotateAngle(drive, setPoint).withTimeout(2),
      new ParallelRaceGroup(
        new CollisionDetect(ahrs),
        new DriveStraight(drive, set_Point)
      )
    );
  }
}
