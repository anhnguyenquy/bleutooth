// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.DriveBase;
import static frc.robot.Constants.WheelDiameter.*;
import edu.wpi.first.wpilibj.Encoder;
import com.kauailabs.navx.frc.AHRS;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoTask extends ParallelCommandGroup {
  private static Encoder encoder = new Encoder(1,2); // Create a new encoder
  /** Creates a new Autotask. */
  public AutoTask(DriveBase drive,Encoder encoder,AHRS ahrs) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //new DriveStraight(drive, 0.5),
      new CollisionDetect(drive,ahrs),
      new Straight(drive,TickCalculation(),encoder)
    );
  }
  public static double TickCalculation(){ // calculate the tick in the encoder to get to the setpoint
    return encoder.get()/1024*diameter*Math.PI;
  }
}
