package maciek.martianrobots.robot;

import lombok.RequiredArgsConstructor;
import maciek.martianrobots.RobotLog;
import maciek.martianrobots.RobotPosition;

/**
 * {@linkplain RobotState State} of {@linkplain Robot robot} that has "fallen
 * off" the edge.
 */
@RequiredArgsConstructor
class Lost implements RobotState {

	private final RobotPosition finalPosition;

	@Override
	public RobotState turnLeft() {
		return this;
	}

	@Override
	public RobotState turnRigth() {
		return this;
	}

	@Override
	public RobotState tryToTakeStepForward() {
		return this;
	}

	@Override
	public RobotLog generateRobotLog() {
		return new RobotLog(finalPosition, true);
	}

}
