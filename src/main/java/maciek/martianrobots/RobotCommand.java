package maciek.martianrobots;

import maciek.martianrobots.robot.Robot;

/**
 * Command that can be issued to {@linkplain Robot robot}.
 */
public interface RobotCommand {

	/**
	 * {@linkplain Robot The robot} moves forward one {@linkplain Grid grid
	 * field} in the direction of the current {@linkplain Orientation
	 * orientation} and maintains the same orientation.
	 */
	public static final RobotCommand F = (robot) -> robot.tryToTakeStepForward();

	/**
	 * {@linkplain Robot The robot} turns left 90 degrees and remains on the
	 * current {@linkplain Grid grid field}.
	 */
	public static final RobotCommand L = (robot) -> robot.turnLeft();

	/**
	 * {@linkplain Robot The robot} turns right 90 degrees and remains on the
	 * current {@linkplain Grid grid field}.
	 */
	public static final RobotCommand R = (robot) -> robot.turnRight();

	void applyTo(Robot robot);

}
