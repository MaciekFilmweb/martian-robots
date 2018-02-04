package maciek.martianrobots;

import lombok.RequiredArgsConstructor;
import maciek.martianrobots.input.Input;
import maciek.martianrobots.input.InputParser;
import maciek.martianrobots.input.RobotInput;
import maciek.martianrobots.output.OutputFormatter;

/**
 * Encapsulates the {@linkplain MartianRobotsApp app's} logic.
 */
@RequiredArgsConstructor
public class MartianRobotsService {

	private final InputParser parser;
	private final OutputFormatter formatter;

	/**
	 * @param input
	 *            the {@linkplain MartianRobotsApp app's} input as in the
	 *            specification
	 */
	public String processInput(String input) {

		Input parsedInput = parser.parse(input);

		MartianRobotsController controller = MartianRobotsController
		        .create(parsedInput.getGridDimensions());

		for (RobotInput robotInput : parsedInput.getRobotInputs()) {
			controller.process(robotInput);
		}

		return formatter.format(controller.generateOutput());
	}

}
