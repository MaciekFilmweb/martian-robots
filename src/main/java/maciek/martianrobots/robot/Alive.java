package maciek.martianrobots.robot;

import lombok.AllArgsConstructor;
import maciek.martianrobots.Coordinates;
import maciek.martianrobots.Grid;
import maciek.martianrobots.RobotLog;
import maciek.martianrobots.RobotPosition;

/**
 * {@linkplain RobotState State} of "alive" {@linkplain Robot robot}.
 */
@AllArgsConstructor
class Alive implements RobotState {

	private final Grid grid;

	private RobotPosition position;

	@Override
	public RobotState turnLeft() {
		position = position.turnLeft();
		return this;
	}

	@Override
	public RobotState turnRigth() {
		position = position.turnRight();
		return this;
	}

	@Override
	public RobotState tryToTakeStepForward() {
		RobotPosition nextPosition = position.stepForward();

		if (grid.contains(nextPosition.getCoordinates())) {
			this.position = nextPosition;
			return this;
		}

		Coordinates coords = position.getCoordinates();
		if (!grid.hasScent(coords)) {
			grid.leaveScent(coords);
			return new Lost(position);
		}
		return this;
	}

	@Override
	public RobotLog generateRobotLog() {
		return new RobotLog(position, false);
	}

}
