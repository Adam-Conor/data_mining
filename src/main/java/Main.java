import java.util.HashSet;

/**
	Name files: yyyy_w? eg 2015_9 for year 2015 and week 9
 */

/**
 * Class to drive the code for the assignment
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-11-30
 */
public class Main {
	public static void main(String[] args) {
		/* Get all the weeks data in a week array */
		Week[] weeks = Utils.getWeeks();
		int numPlayers = DataInfo.getTopPlayers();

		/* Arrays for holding the quatile information */
		Double[] upperQs = new Double[weeks.length];
		Double[] upperWhiskers = new Double[weeks.length];

		/* Global pointer for tracking progress */
		int pointer = 0;

		/* Set for classifying player as potential winner */
		HashSet<String> potentialPlayer = new HashSet<>();

		/* Get the upper whiskers for classifying players */
		for(int i = 0; i < weeks.length; i++) {
			Double[] results = new Double[numPlayers];
			int resultPointer = 0;

			Player[] players = weeks[i].getPlayers();

			for(Player p : players) {
				results[resultPointer] = p.getAvgPoints();

				resultPointer++;
			}

			Double upperQ = Arithmetic.upperQ(results);
			upperWhiskers[pointer] = upperQ + Arithmetic.iqr(results) * 1.5;

			pointer++;
		}

		/* Classify a player a potential winner by checking if they ever make it over the upper whisker */
		for(Week w : weeks) {
			Player[] players = w.getPlayers();
			int weekPointer = w.getWeekNumber() - 1;

			for(Player p : players) {
				if(p.getAvgPoints() >= upperWhiskers[weekPointer]) {
					/* Classify player as potential */
					potentialPlayer.add(p.getName());
				}
			}
		}

		Object[] potentialPlayerArray = potentialPlayer.toArray();

		/* Show potential players */
		for(Object o : potentialPlayerArray) {
			String pPlayer = o.toString();

			//System.out.println(pPlayer);
		}

		int size = weeks.length * potentialPlayerArray.length;

		/* Player potentialPlayerArray[0] = playersTotal*[0] 
			 Player potentialPlayerArray[1] = playersTotal*[1]
			 Player potentialPlayerArray[2] = playersTotal*[2]
			 Player potentialPlayerArray[N] = playersTotal*[N]
		 */
		/* Get the players scores into array to detemine who will win */
		Double[] playersTotalPoints = new Double[size];
		Double[] playersTotalGained = new Double[size];
		Double[] playersTotalLost = new Double[size];
		pointer = 0;

		for(Week w : weeks) {
			for(Object o : potentialPlayerArray) {
				String name = o.toString();

				Player p = w.getPlayer(name);

				playersTotalPoints[pointer] = p.getAvgPoints();
				playersTotalGained[pointer] = p.getTotalPointsGained();
				playersTotalLost[pointer] = p.getTotalPointsLost();

				pointer++;
			}
		}

		/* Find the winner */
		String winnerName = "";
		Double winnerScore = 0.0;
		for(int i = 0; i < playersTotalPoints.length; i++) {
			if(playersTotalGained[i] > winnerScore) {
				winnerScore = playersTotalGained[i];
				winnerName = (String) potentialPlayerArray[i % 3];
			}
		}

		System.out.println("Player to win: " + winnerName);
	}
}
