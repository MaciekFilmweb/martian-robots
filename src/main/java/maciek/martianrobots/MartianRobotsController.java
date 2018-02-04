package maciek.martianrobots;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import maciek.martianrobots.input.RobotInput;
import maciek.martianrobots.output.Output;
import maciek.martianrobots.output.Output.OutputBuilder;
import maciek.martianrobots.robot.Robot;

/**
 * Controls {@linkplain Robot robots}.
 */
@RequiredArgsConstructor
public class MartianRobotsController {

	private final Grid grid;

	private List<Robot> robots = new ArrayList<>();

	/**
	 * @param gridDimensions
	 *            {@linkplain Grid the rectangular martian surface} upper-right
	 *            corner {@linkplain Coordinates coordinates}
	 */
	public static MartianRobotsController create(Coordinates gridDimensions) {
		return new MartianRobotsController(Grid.create(gridDimensions));
	}

	/**
	 * Creates {@linkplain Robot robot} with given {@linkplain RobotPosition
	 * initial position}.
	 */
	public Robot createRobot(RobotPosition position) {
		Robot robot = new Robot(grid, position);
		robots.add(robot);
		return robot;
	}

	/**
	 * Processes {@linkplain RobotInput input} for next {@linkplain Robot
	 * robot}.
	 */
	public void process(RobotInput input) {
		Robot robot = createRobot(input.getInitialPosition());

		for (RobotCommand command : input.getCommands()) {
			command.applyTo(robot);
		}
	}

	/**
	 * Generates {@linkplain Output the output}.
	 */
	public Output generateOutput() {
		OutputBuilder outputBuilder = Output.builder();
		for (Robot robot : robots) {
			outputBuilder.robotLog(robot.getRobotLog());
		}
		return outputBuilder.build();
	}

}
