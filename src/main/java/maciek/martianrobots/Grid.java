package maciek.martianrobots;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import maciek.martianrobots.robot.Robot;

/**
 * The grid of the rectangular martian surface.
 * <p>
 * The surface is divided into fields on which {@linkplain Robot robots} or
 * robot scents can be located.
 * <p>
 * Each field has assigned {@linkplain Coordinates coordinates}.
 */
@RequiredArgsConstructor
public class Grid {

	/**
	 * This map represents fields of the grid.
	 * <p>
	 * The map's keys are the fields {@linkplain Coordinates coordinates}, while
	 * the values indicate presence of a robot scent.
	 */
	@Singular
	private final Map<Coordinates, Boolean> fields;

	public static Grid create(Coordinates dimensions) {
		Map<Coordinates, Boolean> fieldsMap = new HashMap<>();

		for (int x = 0; x <= dimensions.getX(); x++) {
			for (int y = 0; y <= dimensions.getY(); y++) {
				fieldsMap.put(new Coordinates(x, y), false);
			}
		}

		return new Grid(fieldsMap);
	}

	/**
	 * Returns {@code true} if the field is within the martian surface,
	 * {@code false} otherwise.
	 */
	public boolean contains(Coordinated coordinated) {
		return fields.get(coordinated.getCoordinates()) != null;
	}

	/**
	 * Returns {@code true} if the robot scent is present on the field,
	 * {@code false} otherwise.
	 */
	public boolean hasScent(Coordinated coordinated) {
		return fields.get(coordinated.getCoordinates());
	}

	/**
	 * Leaves robot scent on the field.
	 */
	public void leaveScent(Coordinated coordinated) {
		fields.put(coordinated.getCoordinates(), true);
	}

}
