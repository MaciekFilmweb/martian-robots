package maciek.martianrobots.input;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import maciek.martianrobots.Coordinates;
import maciek.martianrobots.Grid;
import maciek.martianrobots.MartianRobotsApp;

/**
 * The {@linkplain MartianRobotsApp app's} parsed input. Contains
 * {@linkplain Grid the martian surface} {@linkplain Coordinates dimensions} and
 * {@linkplain RobotInput inputs} for all robots.
 */
@Value
@Builder
public class Input {

	private Coordinates gridDimensions;

	@Singular
	private List<RobotInput> robotInputs;

}
