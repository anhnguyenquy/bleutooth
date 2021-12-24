package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;

// Code hướng đi auto của bot theo đường vẽ sau:
// https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/255572184_461010935447210_3869812907424549120_n.png?_nc_cat=102&ccb=1-5&_nc_sid=ae9488&_nc_ohc=QCaXL5EqfKYAX93uKWC&_nc_ht=scontent-sin6-2.xx&oh=03_AVK9eglp8s8a_Ii-E1obrT0MRGa6Z8B68R3kBca0DZ-N2Q&oe=61D8D025

public class MoveAuto extends SequentialCommandGroup {

  public MoveAuto(Drivebase drivebase) {
    addCommands(
      //aslk;da;sldka;lsdk
      // new Rotate(drivebase, -50),
      // new Forward(drivebase, 8.66), // red arrow
      // new Rotate(drivebase, 50),
      // new Forward(drivebase, 1.66), // light blue arrow
      // // nhấc hộp()
      // new Forward(drivebase, -0.66), // lùi lại sau khi nhấc đc thùng xanh
      // new Rotate(drivebase, -50),
      // new Forward(drivebase, 4.66), // dark blue arrow (lên storage area)
      // // drop hộp()
      // new Rotate(drivebase, -180),
      // new Forward(drivebase, 7.33), // yellow arrow 1
      // new Rotate(drivebase, -40),
      // new Forward(drivebase, 3.33), // yellow arrow 2
      // // nhấc hộp();
      // new Rotate(drivebase, 70),
      // new Forward(drivebase, 7.33) // yellow arrow 3
    );
  }

}
