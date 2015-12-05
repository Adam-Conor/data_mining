import java.util.Set;
import java.util.HashMap;
import java.util.Map;

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
	private static final int numWeeks = 48;

	public static void main(String[] args) {
		/* Get all the weeks data in a week array */
		Week[] weeks = Utils.getWeeks();

		//Set<String> distinctPlayerNames = Utils.getDistinctPlayerNames(weeks);
		//Object[] namesFromSet = distinctPlayerNames.toArray();

		//Map<Integer, Double> weekAndPoints = Utils.initWeekAndPoints();
		//Map<String, Map<Integer, Double>> performance = Utils.initNamesWithWeeksAndPoints(namesFromSet, weekAndPoints);
		//for(Object o : namesFromSet) {
		//	for(Week w : weeks) {
		//		Player p = w.getPlayer((String) o);
		//		int weekNo = w.getWeekNumber();

		//		Map<Integer, Double> temp = performance.get((String) o);
		//		temp.put(weekNo, p.getAvgPoints());

		//		performance.put((String) o, temp);
		//	}
		//}
		//
		//for(Object o : namesFromSet) {
		//	Map<Integer, Double> weekly = performance.get((String) o);

		//	System.out.println("For player named: " + o);

		//	for(Integer i = 1; i <= 48; i++) {
		//		Double result = weekly.get(i);
		//		
		//		System.out.println("Week: " + i + " Points: " + result);
		//	}
		//}
		

		//for(Week w : weeks) {
		//	Player[] players = w.getPlayers();
		//	int weekNo = w.getWeekNumber();
		//	System.out.println(weekNo);

		//	for(Player p : players) {
		//		String name = p.getName(); //get the name for the player
		//		Map<Integer, Double> temp = performance.get(name); //get the associated weekNo and result

		//		temp.put(weekNo, p.getAvgPoints()); //add the the new result
		//		performance.put(name, temp); //add new thing to value
		//	}
		//}

		//for(Object o : namesFromSet) {
		//	Map<Integer, Double> weekly = performance.get((String) o);

		//	System.out.println("For player named: " + o);

		//	for(Integer i = 1; i <= 48; i++) {
		//		Double result = weekly.get(i);
		//		
		//		System.out.println("Week: " + i + " Points: " + result);
		//	}
		//}

		//for(Week w : weeks) {
		//	Player[] players = w.getPlayers();

		//	for(Player p : players) {
		//		String name = p.getName();

		//		double temp = playerWithResults.get(name);
		//		temp += p.getTotalPointsGained();

		//		playerWithResults.put(name, temp);
		//	}
		//}
	}
}
