package maciek.martianrobots.robot;

import maciek.martianrobots.RobotLog;

/**
 * State design pattern applied for {@linkplain Robot robot}.
 */
public interface RobotState {

	RobotState turnLeft();

	RobotState turnRigth();

	RobotState tryToTakeStepForward();

	RobotLog generateRobotLog();

}
