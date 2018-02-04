package maciek.martianrobots;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import maciek.martianrobots.robot.Robot;

/**
 * Report from the {@linkplain Robot robot} about its {@linkplain RobotPosition
 * position} and state ("LOST" or "ALIVE").
 */
@Value
@RequiredArgsConstructor
public class RobotLog {

	private RobotPosition position;

	private boolean isRobotLost;

}
