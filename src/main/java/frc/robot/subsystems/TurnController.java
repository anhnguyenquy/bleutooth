// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import static frc.robot.Constants.PID.*;
//import edu.wpi.first.wpilibj.controller.PIDController.*;
public class  TurnController extends SubsystemBase {
  public PIDController turncontroller;
  /** Creates a new PID. */
  public TurnController() {
    turncontroller  = new PIDController(kP, kI, kD); // the constructor
  }
  
  private static TurnController tcontroller = null; 
  public static TurnController getInstance (){ // Create new PiD controller
    if (tcontroller == null){
      tcontroller = new TurnController();
    }
    return tcontroller;
  }
  public void setSetPoint (double x){ 
    turncontroller.setSetpoint(x);   //set the state that the PIDcontroller is aiming to reach
  }

  public void reset (){
    turncontroller.reset();  // reset the intergral term, the previous error
  }
  public void enableContinuousInput(double a, double b) {
    turncontroller.enableContinuousInput(a, b);
    /* Instead of using max and min as constraints, 
    it consider them as a point and calculate 
    the shortest route to the set point*/
   
  }

  public void setIntegratorRange(double m, double n) {
    turncontroller.setIntegratorRange(m, n); 
    // Intergrator is an element, whose output signals is the intergral time of its intputsinal
    // This method sets the range of the intergrator.When it meets the top(or low), add it to 
    // the controller output, not the time intergral
  }

  public void setTolerance() {
    turncontroller.setTolerance(kToleranceDegress, kToleranceAngularVelocity);
// Đặt lỗi được coi là có thể chấp nhận được để sử dụng tại Setpoint ().
  }

  public double calculate(double c) {
    return turncontroller.calculate(c);
// Trả về đầu ra tiếp theo của bộ điều khiển PID.
  }
  public boolean atSetpoint() {
    return turncontroller.atSetpoint();
// Return true if the error is within the tolerance of the set point
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
