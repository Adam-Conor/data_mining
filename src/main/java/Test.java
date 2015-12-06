import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
public class Test {
	private static final int numWeeks = 48;

	public static void main(String[] args) {
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

		for (int k = 0; k < size; k++ ) {
			//System.out.println("Rank: " + rank[k] + "  Average Points: " + avg[k] + " Name: " + name[k]);
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
		//System.out.println(p[46]);
		
		/*
		for(int i = 0; i <= gained.size(); i++) {
			int weekNo = i + 1;
			System.out.println("For week number: " + weekNo);

			Double g = gained.get(weekNo);
			Double l = lost.get(weekNo);

			System.out.println(g / 2);
			// Not very algorithmly but fuck sure take a look haha 
			if((g / 2) < (l * -1)) { //This works sometimes, could we use to determine a leader after some time?
				System.out.println("Leader changes for next week");
			}

			System.out.println("Gained: " + gained.get(weekNo));
			System.out.println("Lost: " + lost.get(weekNo));
		}
		
		*/
	}
}
