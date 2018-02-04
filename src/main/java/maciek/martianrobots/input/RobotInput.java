package maciek.martianrobots.input;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import maciek.martianrobots.Coordinates;
import maciek.martianrobots.RobotCommand;
import maciek.martianrobots.RobotPosition;
import maciek.martianrobots.robot.Robot;

/**
 * Parsed input for single {@linkplain Robot robot}. Consists of the robot
 * initial {@linkplain Coordinates coordinates} and the list of
 * {@linkplain RobotCommand robot instructions}.
 */
@Value
@Builder
public class RobotInput {

	private RobotPosition initialPosition;

	@Singular
	private List<RobotCommand> commands;

}
