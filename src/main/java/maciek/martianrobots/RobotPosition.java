package maciek.martianrobots;

import lombok.Builder;
import lombok.Data;
import maciek.martianrobots.robot.Robot;

/**
 * {@linkplain Coordinates Coordinates} and {@linkplain Orientation orientation}
 * of the {@linkplain Robot robot}.
 */
@Data
@Builder
public class RobotPosition implements Coordinated {

	private final Coordinates coordinates;

	private final Orientation orientation;

	/**
	 * Returns robot position after turning left by the {@linkplain Robot robot}
	 * from current position.
	 */
	public RobotPosition turnLeft() {
		return new RobotPosition(coordinates, orientation.turnLeft());
	}

	/**
	 * Returns robot position after turning right by the {@linkplain Robot
	 * robot} from current position.
	 */
	public RobotPosition turnRight() {
		return new RobotPosition(coordinates, orientation.turnRight());
	}

	/**
	 * Returns robot position after taking one step forward by the
	 * {@linkplain Robot robot} from current position.
	 */
	public RobotPosition stepForward() {
		return new RobotPosition(orientation.getNext(coordinates), orientation);
	}

	@Override
	public Coordinates getCoordinates() {
		return coordinates;
	}

}
