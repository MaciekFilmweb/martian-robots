package maciek.martianrobots.output;

import java.util.stream.Collectors;

import maciek.martianrobots.Coordinates;
import maciek.martianrobots.MartianRobotsApp;
import maciek.martianrobots.RobotLog;
import maciek.martianrobots.RobotPosition;

/**
 * Formats the {@linkplain MartianRobotsApp app's} {@linkplain Output output} as
 * in the specification.
 */
public class OutputFormatter {

	/**
	 * Formats {@linkplain Output output} as in the specification.
	 * 
	 * <pre>
	 * 1 1 E
	 * 3 3 N LOST
	 * 2 3 S
	 * </pre>
	 */
	public String format(Output output) {

		String formattedOutput = output.getRobotLogs()
		        .stream()
		        .map(this::formatRobotLog)
		        .collect(Collectors.joining("\r\n"));

		return formattedOutput;
	}

	/**
	 * Formats {@linkplain RobotLog robot log} as in the specification.
	 * 
	 * <pre>
	 * 3 3 N LOST
	 * </pre>
	 */
	public String formatRobotLog(RobotLog log) {
		return formatRobotPosition(log.getPosition()) + (log.isRobotLost() ? " LOST" : "");

	}

	/**
	 * Formats {@linkplain RobotPosition position} as in the specification.
	 * 
	 * <pre>
	 * 3 3 N
	 * </pre>
	 */
	private String formatRobotPosition(RobotPosition position) {
		Coordinates coordinates = position.getCoordinates();

		String formattedPosition = new StringBuilder()
		        .append(coordinates.getX())
		        .append(" ")
		        .append(coordinates.getY())
		        .append(" ")
		        .append(position.getOrientation())
		        .toString();

		return formattedPosition;
	}

}
