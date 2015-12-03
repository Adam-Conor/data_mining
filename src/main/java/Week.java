/**
 * Class to encapsulate a week in the pga tour season
 * Has an array of players for each week
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-12-01
 */
class Week {
	private Player[] players;
	private int week;

	private int count;

	/**
	 * Constructor to set the week number and the default player size
	 * @param week number of the week
	 */
	public Week(int week) {
		players = new Player[DataInfo.getMaxPlayers()];
		this.week = week;

		count = 0;
	}

	/**
	 * Constructor to set the week number and the player size
	 * @param week number of the week
	 * @param numberOfPlayers size fo the players array
	 */
	public Week(int week, int numberOfPlayers) {
		players = new Player[numberOfPlayers];
		this.week = week;

		count = 0;
	}

	/**
	 * Set the week number
	 * @param week number of the week as an int
	 */
	public void setWeekNumber(int week) {
		this.week = week;
	}

	/**
	 * Get the week number
	 * @return week number as an int
	 */
	public int getWeekNumber() {
		return week;
	}

	/**
	 * Set the players for that week
	 * @param players players array for that week
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
		count = players.length;
	}

	/**
	 * Get the players for that week
	 * @return player array with the players for this week
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Set a player in the week
	 * Increments inner counter to keep track of elements
	 * @param player the player to be added to the weeks player array
	 */
	public void setPlayer(Player player) {
		players[count] = player;

		count++;
	}

	/**
	 * Get a player at a specified index
	 * @param index the index of the player to return
	 * @return player at specified index
	 */
	public Player getPlayer(int index) {
		return players[index];
	}

	/**
	* Get a player with a specified name
	* Returns error player if not found
	* @return player with specified name, error player
	*/
	public Player getPlayer(String name) {
		for(Player p : players) {
			if(p.getName().equals(name)) {
				return p;
			}
		}

		return new Player("Player Doesnt exist");
	}

	/**
	 * get the size of the player array
	 * @return size of player array as an int
	 */
	public int getPlayerSize() {
		return players.length;
	}

	/**
	 * get the number of player set in the array
	 * @return number of players set as an int
	 */
	public int getNumberOfPlayers() {
		return count;
	}

	/**
	 * toString function to override default toString
	 * @return String representation of the week
	 */
	@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();

			builder.append("Week ");
			builder.append("[");
			builder.append("Week Number: ");
			builder.append(week);
			builder.append(", ");
			builder.append("Players: ");
			builder.append("[");
			//builder.append(players);
			for(Player p : players) {
				builder.append(p);
				builder.append(", ");
			}
			builder.append("]");

			return builder.toString();
		}
}
