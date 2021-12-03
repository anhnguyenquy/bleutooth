// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.spin.speed.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.*;

public class Drivescrew extends SubsystemBase {
  /** Creates a new Drivescrew. */
  public Drivescrew() {
    wheel[9] = new WPI_TalonSRX(9);
  }
  public void rotation (){
    wheel[9].set(drivescrew);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
