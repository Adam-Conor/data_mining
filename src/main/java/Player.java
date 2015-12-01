/**
 * Class for holding information about a player
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-11-30
 */
public class Player {
	private String name;
	private double avgPoints;

	public Player() {}

	/**
	 * Default all-args constructor
	 * @param name name of the player as a string
	 * @param avgPoints average points of the player
	 */
	public Player(String name, double avgPoints) {
		this.name = name;
		this.avgPoints = avgPoints;
	}

	/**
	 * Get the name of the player
	 * @return name of the player as a string
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the player
	 * @param name of the player to be set as a string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the average points for the player
	 * @return average points for the player as a double
	 */
	public double getAvgPoints() {
		return avgPoints;
	}

	/**
	 * Set the average points for a player
	 * @param avgPoints average points to set for the player as a double
	 */
	public void setAvgPoints(double avgPoints) {
		this.avgPoints = avgPoints;
	}

	/**
	 * ToString function
	 * @return String representation of the Player
	 */
	@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Player ");
			builder.append("[");
			builder.append("Name: ");
			builder.append(name);
			builder.append(", ");
			builder.append("Average Points: ");
			builder.append(avgPoints);
			builder.append("]");

			return builder.toString();
		}
}
