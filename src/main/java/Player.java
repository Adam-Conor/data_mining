class Player {
	private String name;
	private double avgPoints;

	public Player() {}

	public Player(String name, double avgPoints) {
		this.name = name;
		this.avgPoints = avgPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgPoints() {
		return avgPoints;
	}

	public void setAvgPoints(double avgPoints) {
		this.avgPoints = avgPoints;
	}

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
