package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.Stop;

// Code hướng đi auto của bot theo đường vẽ sau:
// https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/255572184_461010935447210_3869812907424549120_n.png?_nc_cat=102&ccb=1-5&_nc_sid=ae9488&_nc_ohc=QCaXL5EqfKYAX93uKWC&_nc_ht=scontent-sin6-2.xx&oh=03_AVK9eglp8s8a_Ii-E1obrT0MRGa6Z8B68R3kBca0DZ-N2Q&oe=61D8D025

public class Auto extends SequentialCommandGroup {

  public Auto(Drivebase drivebase) {
    addCommands(
        new DriveStraight(drivebase, 1)
//         new WaitCommand(5),
        // new Stop(drivebase)
    );
  }

}
