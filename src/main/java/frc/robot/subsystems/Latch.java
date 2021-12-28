package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Latch extends SubsystemBase {

	private Relay latch;

	public Latch() {
		latch = new Relay(Relays.latch, Direction.kForward);
	}

	public void extend() {
		latch.set(Value.kOn);
	}

	public void retract() {
		latch.set(Value.kOff);
	}

	@Override
	public void periodic() {
	}
}