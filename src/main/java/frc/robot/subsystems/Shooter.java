// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.*;
public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  public Shooter() {
    wheel[4] = new WPI_TalonSRX(4);
    wheel[5] = new WPI_TalonSRX(5);
    wheel[4].setNeutralMode(NeutralMode.Brake);
    wheel[5].setNeutralMode(NeutralMode.Brake);
  }
  public void shooter (double y){
    wheel[4].set(y);
    wheel[5].set(-y);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
