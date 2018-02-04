package maciek.martianrobots;

/**
 * Sides of the world and its mutual relations.
 */
public enum Orientation {

	/**
	 * North.
	 */
	N {
		@Override
		Orientation turnLeft() {
			return W;
		}

		@Override
		Orientation turnRight() {
			return E;
		}

		@Override
		Coordinates getNext(Coordinates coordinates) {
			return coordinates.add(0, 1);
		}
	},
	/**
	 * South.
	 */
	S {
		@Override
		Orientation turnLeft() {
			return E;
		}

		@Override
		Orientation turnRight() {
			return W;
		}

		@Override
		Coordinates getNext(Coordinates coordinates) {
			return coordinates.add(0, -1);
		}
	},
	/**
	 * East.
	 */
	E {
		@Override
		Orientation turnLeft() {
			return N;
		}

		@Override
		Orientation turnRight() {
			return S;
		}

		@Override
		Coordinates getNext(Coordinates coordinates) {
			return coordinates.add(1, 0);
		}
	},
	/**
	 * West.
	 */
	W {
		@Override
		Orientation turnLeft() {
			return S;
		}

		@Override
		Orientation turnRight() {
			return N;
		}

		@Override
		Coordinates getNext(Coordinates coordinates) {
			return coordinates.add(-1, 0);
		}
	};

	/**
	 * Returns orientation to which one faces after turning left when initially
	 * facing this orientation.
	 */
	abstract Orientation turnLeft();

	/**
	 * Returns orientation to which one faces after turning right when initially
	 * facing this orientation.
	 */
	abstract Orientation turnRight();

	/**
	 * Returns neighboring {@linkplain Grid grid field} {@linkplain Coordinates
	 * coordinates} in the direction of the this {@linkplain Orientation
	 * orientation}.
	 */
	abstract Coordinates getNext(Coordinates coordinates);

}
