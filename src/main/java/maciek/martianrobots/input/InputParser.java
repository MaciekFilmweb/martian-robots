package maciek.martianrobots.input;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.Singular;
import maciek.martianrobots.Coordinates;
import maciek.martianrobots.MartianRobotsApp;
import maciek.martianrobots.Orientation;
import maciek.martianrobots.RobotCommand;
import maciek.martianrobots.RobotPosition;
import maciek.martianrobots.input.Input.InputBuilder;

/**
 * Parses the {@linkplain MartianRobotsApp app's} string input formatted as in
 * the specification.
 */
@RequiredArgsConstructor
public class InputParser {

	@Singular
	private final Map<String, RobotCommand> availableCommands;

	/**
	 * Parses input string.
	 * 
	 * <pre>
	 * 5 3
	 * 1 1 E
	 * RFRFRFRF
	 * 
	 * 3 2 N
	 * FRRFLLFFRRFLL
	 * 
	 * 0 3 W
	 * LLFFFLFLFL
	 * 
	 * </pre>
	 */
	public Input parse(String input) {
		return parse(Arrays.asList(input.trim().split("\\r?\\n")));
	}

	/**
	 * Parses input string as lines.
	 * 
	 * <pre>
	 * 5 3
	 * 1 1 E
	 * RFRFRFRF
	 * 
	 * 3 2 N
	 * FRRFLLFFRRFLL
	 * 
	 * 0 3 W
	 * LLFFFLFLFL
	 * 
	 * </pre>
	 */
	public Input parse(List<String> lines) {
		try {
			Iterator<String> it = lines.iterator();

			InputBuilder inputBuilder = Input.builder()
			        .gridDimensions(parseGridDimensions(it.next()));

			while (it.hasNext()) {
				inputBuilder.robotInput(parseRobotInput(it.next(), it.next()));
			}

			return inputBuilder.build();

		} catch (Exception e) {
			throw new IllegalArgumentException("Exception while parsing input " + lines, e);
		}
	}

	/**
	 * Parses dimensions that marks upper right corner of the rectangular grid.
	 * 
	 * <pre>
	 * 5 3
	 * </pre>
	 */
	private Coordinates parseGridDimensions(String dimensions) {
		String[] split = dimensions.split(" ");
		return new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
	}

	/**
	 * Parses two lines that codes input for single robot.
	 * 
	 * <pre>
	 * 1 1 E
	 * RFRFRFRF
	 * 
	 * </pre>
	 */
	private RobotInput parseRobotInput(String positionLine, String commandsLine) {
		return RobotInput.builder()
		        .initialPosition(parseInitialRobotPosition(positionLine))
		        .commands(parseRobotCommands(commandsLine))
		        .build();
	}

	/**
	 * Parses initial position of a robot.
	 * 
	 * <pre>
	 * 1 1 E
	 * </pre>
	 */
	private RobotPosition parseInitialRobotPosition(String positionLine) {

		String[] split = positionLine.split(" ");

		RobotPosition position = RobotPosition.builder()
		        .coordinates(new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1])))
		        .orientation(Orientation.valueOf(split[2])).build();

		return position;

	}

	/**
	 * Parses commands issued to the robot.
	 * 
	 * <pre>
	 * RFRFRFRF
	 * </pre>
	 */
	private List<RobotCommand> parseRobotCommands(String commandsLine) {
		return commandsLine.chars()
		        .mapToObj(ch -> String.valueOf((char) ch))
		        .map(ch -> availableCommands.get(ch))
		        .collect(Collectors.toList());

	}
	
}
