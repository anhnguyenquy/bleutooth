package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intakers;
import frc.robot.subsystems.Drivebase;

public class Auto extends ParallelCommandGroup {
  
  public Auto(Intakers intakers, Drivebase drive ) {
    addCommands(
      // new Suck(intakers),
      // new MoveAuto(drive)
    );
  }
  
}
