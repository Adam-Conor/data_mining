/**
 * Class for holding information about a player
 * All work is our own
 * TODO Add getters and setters for new fields
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-11-30
 */
public class Player {
	private String name;

	private double avgPoints;
	private double rank;
	private double prevRank;
	private double totalPoints;
	private double divisorEvents;
	private double actualEvents;
	private double totalPointsGained;
	private double totalPointsLost;

	public Player() {}

	/**
	 * Default all-args constructor
	 * @param name name of the player as a string
	 * @param avgPoints average points of the player
	 */
	public Player(String name, double avgPoints, double rank, double prevRank, 
			double totalPoints, double divisorEvents, double actualEvents, double totalPointsGained, double totalPointsLost) {
		this.name = name;
		this.avgPoints = avgPoints;
		this.rank = rank;
		this.prevRank = prevRank;
		this.totalPoints = totalPoints;
		this.divisorEvents = divisorEvents;
		this.actualEvents = actualEvents;
		this.totalPointsGained = totalPointsGained;
		this.totalPointsLost = totalPointsLost;
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
			builder.append(", ");
			builder.append("Rank: ");
			builder.append(rank);
			builder.append(", ");
			builder.append("Previous Rank: ");
			builder.append(prevRank);
			builder.append(", ");
			builder.append("Total Points: ");
			builder.append(totalPoints);
			builder.append(", ");
			builder.append("Divisor Events: ");
			builder.append(divisorEvents);
			builder.append(", ");
			builder.append("Actual Events: ");
			builder.append(actualEvents);
			builder.append(", ");
			builder.append("Total Points Gained: ");
			builder.append(totalPointsGained);
			builder.append(", ");
			builder.append("Total Points Lost: ");
			builder.append(totalPointsLost);
			builder.append("]");

			return builder.toString();
		}
}
