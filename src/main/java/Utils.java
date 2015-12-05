import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
* Mostly ignore this class for now, was experimenting
*/

class Utils {
	public static final int numWeeks = DataInfo.getMaxWeeks();

	public static Week[] getWeeks() {
		Week[] weeks = new Week[numWeeks];

		for(int i = 0; i < weeks.length; i++) {
			weeks[i] = getWeek(i + 1);
		}

		return weeks;
	}

	public static Week getWeek(int weekNumber) {
		String fileName = DataInfo.CSV_ROOT + DataInfo.get2015Prefix() + weekNumber + DataInfo.getCsvSuffix();

		Reader reader = new Reader(fileName);

		reader.readAll();

		int size = DataInfo.getMaxPlayers();

		Week week = new Week(weekNumber, size);

		for(int i = 0; i < size; i++) {
			Player p = reader.getPlayer();

			week.setPlayer(p);
		}

		return week;
	}

	private static List<String> getAllPlayerNames(Week[] weeks) {
		String[] x = new String[numWeeks * DataInfo.getMaxPlayers()];
		int pointer = 0;

		for(Week w : weeks) {
			Player[] players = w.getPlayers();

			for(Player p : players) {
				x[pointer] = p.getName();
				pointer++;
			}
		}

		return Arrays.asList(x);
	}

	public static Set<String> getDistinctPlayerNames(Week[] weeks) {
		List<String> allPlayerNames = getAllPlayerNames(weeks);

		Set<String> distinctPlayerNames = new HashSet<>();
		
		distinctPlayerNames.addAll(allPlayerNames);

		return distinctPlayerNames;
	}

	public static Map<String, Double> putPlayersInMap(Object[] names) {
		HashMap<String, Double> x = new HashMap<String, Double>();

		for(Object o : names) {
			x.put((String) o, 0.0);
		}

		return x;
	}

	public static Map<Integer, Double> initWeekAndPoints() {
		HashMap<Integer, Double> x = new HashMap<>();

		for(int i = 1; i <= 48; i++) {
			x.put(i, 0.0);
		}

		return x;
	}

	public static Map<String, Map<Integer, Double>> initNamesWithWeeksAndPoints(Object[] names, Map<Integer, Double> weekAndResult) {
		HashMap<String, Map<Integer, Double>> x = new HashMap<>();

		for(Object o : names) {
			x.put((String) o, weekAndResult);
		}

		return x;
	}

	public static void printNames(Set<String> names) {
		for(Object o : names.toArray()) {
			System.out.println(o);
		}
	}
}
