import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
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
		/* Simple classification and prediction described in Report */
		simpleClassificationAndPrediction();

		/* Exponential Regression attempt described in Report */
		exponentialRegression();
	}

	public static void simpleClassificationAndPrediction() {
		/* Get all the weeks data in a week array */
		Week[] weeks = Utils.getWeeks();
		int numPlayers = DataInfo.getTopPlayers();

		/* Arrays for holding the quatile information */
		Double[] upperQs = new Double[weeks.length];
		Double[] upperWhiskers = new Double[weeks.length];

		/* Global pointer for tracking things */
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
				winnerName = (String) potentialPlayerArray[i % potentialPlayerArray.length];
			}
		}

		System.out.println("Player to win: " + winnerName);
	}

	public static void exponentialRegression() {
		/* Top 30 players */
		int size = DataInfo.getTopPlayers();
		/* Get all the weeks data in a week array */
		Week[] weeks = Utils.getWeeks();

		// Arrays for holding golf and performance data
		double[] rank = new double[size];
		double[] avg = new double[size];
		String[] name = new String[size];
		double[] diff = new double[size];
		double[] totGained = new double[size];
		double[] totLost = new double[size];

		Player[] p = weeks[12].getPlayers();


		// Arrays of data for testing regression with any two variables
		for (int i = 0; i < size; i++) {
			rank[i] = p[i].getRank();
			avg[i]  = p[i].getAvgPoints();
			name[i] = p[i].getName();
			diff[i] = p[i].getPointsDifference();
			totGained[i]= p[i].getTotalPointsGained();
			totLost[i]  = p[i].getTotalPointsLost();
		}

		Double e = Math.E;
		Double sumX = 0.00;
		Double sumX2 = 0.00;
		Double sumY = 0.00;
		Double sumYlin = 0.00;
		Double sumY2 = 0.00;
		Double sumY2lin = 0.00;
		Double sumXY = 0.00;
		Double sumXYlin = 0.00;

		for(int i=0;i<size;i++)
		{
			// Sum of Squares described in Report for exponential
			sumX = sumX + rank[i];
			sumX2 = sumX2 + Math.pow(rank[i], 2);

			// exponential
			sumY = sumY + Math.log(avg[i]);
			sumY2 = sumY2 + Math.pow(Math.log(avg[i]), 2);
			sumXY = sumXY + (rank[i]*(Math.log(avg[i])));

		}
		// In report
		Double b = 0.00;
		b = ((size*sumXY) - (sumX*sumY))/(size*sumX2 - (sumX*sumX));

		// In report
		Double a = 0.00;
		a = Math.pow(e, (sumY - (b*sumX))/size);

		System.out.println("Exponential regression model for variables:");
		System.out.println("y = " + a + "*(e^(" + b + "*x))");
	}
}
