import java.util.*;

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
		simpleClassificationAndPrediction();
		whatWillICallThis();
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
				winnerName = (String) potentialPlayerArray[i % potentialPlayerArray.length];
			}
		}

		System.out.println("Player to win: " + winnerName);
	}

	public static void whatWillICallThis() {
		int size = DataInfo.getTopPlayers();
		/* Get all the weeks data in a week array */
		Week[] weeks = Utils.getWeeks();

		/* All work for the leader per week */
		HashMap<Integer, Double> gained = new HashMap<>();
		HashMap<Integer, Double> lost = new HashMap<>();
		HashMap<Integer, Double> pointsDifference = new HashMap<>();
		HashMap<Integer, Player[]> play = new HashMap<>();
		String first = weeks[0].getPlayer(0).getName();

		for(Week w : weeks) {
			Player player = w.getPlayer(0);
			if(!player.getName().equals(first)) {
				first = player.getName();
			}

			Double pointsGained = player.getTotalPointsGained();
			Double pointsLost = player.getTotalPointsLost();
			int weekNo = w.getWeekNumber();
			System.out.println(player.getPointsDifference());

			gained.put(weekNo, pointsGained);
			lost.put(weekNo, pointsLost);
			pointsDifference.put(weekNo, player.getPointsDifference());
		}


		HashMap<String, ArrayList<Double>> performance = new HashMap<>();
		ArrayList<Double> playerPerf = new ArrayList<>();

		for(Week w : weeks){
			Player[] p = new Player[size];
			for (int j = 0; j < size; j++) {
				p[j] = w.getPlayer(j);
				play.put(w.getWeekNumber(), p);
			}
		}

		Double value = 0.0;
		for (Map.Entry<Integer, Player[]> entry : play.entrySet() ) {
			Player[] ps = entry.getValue();
			int i = 0;
			for (Player p : ps ) {
				if(p.getName().equals("Jason Day")){
					System.out.println("Rank : " + p.getRank());
					System.out.println("Points Difference: " + p.getPointsDifference());
					System.out.println("Average Points: " + p.getAvgPoints());
					System.out.println("Events: " + p.getDivisorEvents());
					System.out.println("Actual Events: " + p.getActualEvents());
					System.out.println();
					break;
				} 
				else i++;
			}
			value += ps[i].getPointsDifference();
		}


		double[] rank = new double[size];
		double[] avg = new double[size];
		String[] name = new String[size];
		double[] diff = new double[size];
		double[] totGained = new double[size];
		double[] totLost = new double[size];
		//weeks[0].getPlayer(0).getName();
		Player[] p = weeks[0].getPlayers();

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
			sumX = sumX + diff[i];
			sumX2 = sumX2 + Math.pow(diff[i], 2);

			// exponential
			sumY = sumY + Math.log(avg[i]);
			sumY2 = sumY2 + Math.pow(Math.log(avg[i]), 2);
			sumXY = sumXY + (diff[i]*(Math.log(avg[i])));

			// linear
			//sumYlin = sumYlin + energy.get(i);
			//sumY2lin = sumY2lin + Math.pow(energy.get(i),2);
			//sumXYlin = sumXYlin + oat.get(i)*energy.get(i);
		}
		Double b = 0.00;
		b = ((size*sumXY) - (sumX*sumY))/(size*sumX2 - (sumX*sumX));

		Double a = 0.00;
		a = Math.pow(e, (sumY - (b*sumX))/size);

		Double c = 0.00;	// numerator
		Double d = 0.00;	// denominator
		Double r = 0.00;	// coefficient of determination
		c = (b)*(sumXY - sumX*sumY/size);
		d = sumY2 - (sumY*sumY)/size;
		r = c/d;

		Double p1 = 0.00;
		if(r > 0){
			p1 = Math.sqrt(r);
		} else {
			p1 = 0.00;
		}
		Double std_err = 0.00;
		std_err = Math.sqrt((d-c)/(size-2));

		System.out.println("Exponential regression model for n equals " + size + ":");
		System.out.println("y = " + a + "*(e^(" + b + "*x))");
		System.out.println("R-square value equals " + r);
		System.out.println("Correlation equals " + p1);
		System.out.println("Standard Error equals " + std_err);
		System.out.println("");	
	}
}
