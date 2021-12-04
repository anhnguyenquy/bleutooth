// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.speed.*;
import static frc.robot.Constants.ArrayConstant.*;

public class Sucker extends SubsystemBase {
  
  /** Creates a new Sucker. */
  public Sucker() {
    wheel[6] = new WPI_TalonSRX(6);
  }
  public void speedWheel(){
    wheel[6].set(speed1);
  }
  public void stop(){
    wheel[6].set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
