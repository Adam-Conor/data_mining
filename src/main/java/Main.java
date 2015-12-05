import java.util.Set;
import java.util.HashMap;

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

		//HashMap<String, Double> playerWithResults = new HashMap<>(); //not sure about this
		Set<String> distinctPlayerNames = Utils.getDistinctPlayerNames(weeks);

		HashMap<String, Double> playerWithResults = new HashMap<>();
		Object[] setArray = distinctPlayerNames.toArray();
		Utils.printNames(distinctPlayerNames);

		/* Store all the possible player names */
		//String[] playerNames = new String[400];
		//List<String>
		//int pointer = 0;

		//int mess = 0;
		//for(Week w : weeks) {
		//	Player[] players = w.getPlayers();

		//	for(Player p : players) {
		//		playerNames[pointer] = p.getName();
		//		pointer++;
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
