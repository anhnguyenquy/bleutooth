package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import static frc.robot.Constants.PID.*;

public class TurnController extends SubsystemBase {

  private PIDController turncontroller;
  private static TurnController tcontroller = null;

  public TurnController() {
    turncontroller = new PIDController(kP, kI, kD); 
  }

  public static TurnController getInstance() { // Creates an instance a PIDController
    if (tcontroller == null) {
      tcontroller = new TurnController();
    }
    return tcontroller;
  }

  public void setSetPoint(double x) {
    turncontroller.setSetpoint(x); // set góc cần quay (input dương thì quay phải)
  }

  public void reset() {
    turncontroller.reset(); // reset the intergral term, the previous error
  }

  public void enableContinuousInput(double a, double b) {
    turncontroller.enableContinuousInput(a, b);
    // Rather then using the max and min input range as constraints, it considers them to be 
    // the same point and automatically calculates the shortest route to the setpoint.
  }

  public void setIntegratorRange(double m, double n) {
    turncontroller.setIntegratorRange(m, n);
  }

  public void setTolerance() {
    turncontroller.setTolerance(kToleranceDegress, kToleranceAngularVelocity); // angular velocity: rad/s
    // Đặt lỗi được coi là có thể chấp nhận được để sử dụng tại Setpoint().
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
    
  }

}
