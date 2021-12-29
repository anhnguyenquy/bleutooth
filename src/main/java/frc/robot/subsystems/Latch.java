package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.RobotContainer.*;

public class Latch extends SubsystemBase {

	private WPI_TalonSRX latch;
	private double speed;

	public Latch() {
		latch = new WPI_TalonSRX(Motors.latch);
	}

	public void extend() {
		speed = 0;
		latch.set(0);
	}

	public void retract() {
		speed = 1;
		latch.set(speed);
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("latch", speed);
	}
}