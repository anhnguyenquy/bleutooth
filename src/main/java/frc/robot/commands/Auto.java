package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intakers;
import frc.robot.subsystems.DriveBase;

import static frc.robot.Constants.AutoParams;

public class Auto extends ParallelCommandGroup {
  public Auto(Intakers intakers, DriveBase drive ) {
    addCommands(
      // "Scripted sequence" style of autonomous command
      new Suck(intakers),
      new RotateAngle(drive, AutoParams.Angles.initialAngle),
      new DriveStraight(drive, AutoParams.Speeds.driveSpeed)
      // Add auto-time instructions here
    );
  }
}
