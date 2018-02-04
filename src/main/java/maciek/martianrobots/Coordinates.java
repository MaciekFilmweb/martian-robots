package maciek.martianrobots;

import lombok.Value;

/**
 * Specifies the location of the object on {@linkplain Grid the rectangular
 * martian surface}.
 * <p>
 * Consists of {@code x} and {@code y} components.
 */
@Value
public class Coordinates implements Coordinated {

	private int x;

	private int y;

	/**
	 * Creates new {@linkplain Coordinates coordinates} in given distance from
	 * this coordinates.
	 */
	public Coordinates add(int x, int y) {
		return new Coordinates(this.x + x, this.y + y);
	}

	@Override
	public Coordinates getCoordinates() {
		return this;
	}

}
