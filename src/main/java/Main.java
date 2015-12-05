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
		/* All work for the leader per week */
		HashMap<Integer, Double> gained = new HashMap<>();
		HashMap<Integer, Double> lost = new HashMap<>();
		String first = weeks[0].getPlayer(0).getName();

		for(Week w : weeks) {
			Player player = w.getPlayer(0);
			if(!player.getName().equals(first)) {
				first = player.getName();

				System.out.println("Changes to: " + first + " in week " + w.getWeekNumber());
			}
			Double pointsGained = player.getTotalPointsGained();
			Double pointsLost = player.getTotalPointsLost();
			int weekNo = w.getWeekNumber();

			gained.put(weekNo, pointsGained);
			lost.put(weekNo, pointsLost);
		}

		for(int i = 0; i <= gained.size(); i++) {
			int weekNo = i + 1;
			System.out.println("For week number: " + weekNo);
			Double g = gained.get(weekNo);
			Double l = lost.get(weekNo);
			System.out.println(g / 2);
			if((g / 2) < (l * -1)) { //This works sometimes, could we use to determine a leader after some time?
				System.out.println("Leader changes for next week");
			}

			System.out.println("Gained: " + gained.get(weekNo));
			System.out.println("Lost: " + lost.get(weekNo));
		}
	}
}
