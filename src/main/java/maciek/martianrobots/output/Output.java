package maciek.martianrobots.output;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import maciek.martianrobots.MartianRobotsApp;
import maciek.martianrobots.RobotLog;

/**
 * The {@linkplain MartianRobotsApp app's} parsed output. Contains
 * {@linkplain RobotLog robot log} of each {@linkplain Robot robot}.
 */
@Value
@Builder
public class Output {

	@Singular
	private List<RobotLog> robotLogs;

}
