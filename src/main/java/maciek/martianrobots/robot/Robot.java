package maciek.martianrobots.robot;

import maciek.martianrobots.Grid;
import maciek.martianrobots.RobotLog;
import maciek.martianrobots.RobotPosition;

/**
 * Represents a martian robot. Can accept {@linkplain RobotCommand instructions}
 * and generate {@linkplain ReportLog report}.
 */
public class Robot {

	private RobotState state;

	public Robot(Grid grid, RobotPosition initialPosition) {
		this.state = createState(grid, initialPosition);
	}

	private static RobotState createState(Grid grid, RobotPosition initialPosition) {
		if (grid.contains(initialPosition)) {
			return new Alive(grid, initialPosition);
		} else {
			return new Lost(initialPosition);
		}
	}

	public void turnLeft() {
		state = state.turnLeft();
	}

	public void turnRight() {
		state = state.turnRigth();
	}

	public void tryToTakeStepForward() {
		state = state.tryToTakeStepForward();
	}

	public RobotLog getRobotLog() {
		return state.generateRobotLog();
	}

}
