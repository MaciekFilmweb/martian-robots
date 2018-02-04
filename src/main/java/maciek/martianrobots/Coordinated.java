package maciek.martianrobots;

/**
 * Convenience interface for objects that have {@linkplain Coordinates
 * coordinates} assigned.
 * <p>
 * Enables passing whole object instead of its coordinates.
 */
public interface Coordinated {

	/**
	 * Returns this object's coordinates.
	 */
	Coordinates getCoordinates();

}
