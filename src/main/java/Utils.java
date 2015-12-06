/**
 * Class for utility stuff
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-12-04
 */ 
class Utils {
	public static final int numWeeks = 26;//DataInfo.getMaxWeeks() / 2;

	/**
	 * Get all the weeks in the csv files
	 * @return all weeks as week array
	 */
	public static Week[] getWeeks() {
		Week[] weeks = new Week[numWeeks];

		for(int i = 0; i < weeks.length; i++) {
			weeks[i] = getWeek(i + 1);
		}

		return weeks;
	}

	/**
	 * Get a single week
	 * @param weekNumber the week number to get
	 * @return week corresponding to the parameter
	 */
	public static Week getWeek(int weekNumber) {
		String fileName = DataInfo.CSV_ROOT + DataInfo.get2015Prefix() + weekNumber + DataInfo.getCsvSuffix();

		Reader reader = new Reader(fileName);

		reader.readAll();

		int size = DataInfo.getTopPlayers();

		Week week = new Week(weekNumber, size);

		for(int i = 0; i < size; i++) {
			Player p = reader.getPlayer();

			week.setPlayer(p);
		}

		return week;
	}
}
