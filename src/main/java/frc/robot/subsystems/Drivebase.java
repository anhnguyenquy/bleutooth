// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import static frc.robot.Constants.spin.*;
import static frc.robot.Constants.joystick.*;
import static frc.robot.Constants.ArrayConstant.*;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivebase extends SubsystemBase { 
  /** Creates a new Drivebase. */
  public Drivebase() {
    int [] x = {Rightmaster, Leftmaster, Rightfollow, Leftfollow};
    
    wheel[0] = new WPI_TalonSRX(x[0]);
    wheel[0].setNeutralMode(NeutralMode.Brake);
    wheel[1] = new WPI_TalonSRX(x[1]);
    wheel[1].setNeutralMode(NeutralMode.Brake);
    wheel[2] = new WPI_TalonSRX(x[2]);
    wheel[2].setNeutralMode(NeutralMode.Brake);
    wheel[3] = new WPI_TalonSRX(x[3]);
    wheel[3].setNeutralMode(NeutralMode.Brake);
  
    wheel[2].follow(wheel[0]);
    wheel[3].follow(wheel[1]);
    wheel[0].setInverted(true);
  }
  public void drive(double rightMaster, double leftMaster) {
    wheel[0].set(rightMaster);
    wheel[1].set(leftMaster);
  }
  public double rawAxis(double y){
    return (RobotContainer.stic.getRawAxis(stick)*y);
  }
  
  @Override
  public void periodic() {
    double x = RobotContainer.stic.getRawButton(8)? 0.5: 0.2;
    drive (rawAxis(x), rawAxis(x));

    // This method will be called once per scheduler run
  }
}
