package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intakers;
import frc.robot.subsystems.DriveBase;

import static frc.robot.Constants.Angles.Autonomous;

public class Auto extends ParallelCommandGroup {
  
  public Auto(Intakers intakers, DriveBase drive) {
    addCommands(
      new Suck(intakers),
      new DriveStraight(drive, 0.8),
      new RotateAngle(drive, Autonomous.startingAngle)
    );
  }
  
}
