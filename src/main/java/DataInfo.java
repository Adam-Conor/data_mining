/**
 * Class for holding information about the format of the data such as
 * total number of rows and index of values in csv file
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-11-30
 */
public class DataInfo {
	private static final int TOP_PLAYERS = 30;
	private static final int MAX_PLAYERS = 300;

	private static final int INDEX_OF_NAME = 3;
	private static final int INDEX_OF_POINTS = 5;

	private static final String PREFIX = "2015_";
	private static final String CSV_SUFFIX = ".csv";

	/**
	 * Get the top players, defined as top 30 for now
	 * @return number of top players
	 */
	public static int getTopPlayers() {
		return TOP_PLAYERS;
	}

	/**
	 * Get the maximum numbers of rows to be read from a csv file
	 * @return maximum number of rows to be read
	 */
	public static int getMaxPlayers() {
		return MAX_PLAYERS;
	}

	/**
	 * Get the index of the name field in csv file
	 * @return position of the name field as int
	 */
	public static int getIndexOfName() {
		return INDEX_OF_NAME;
	}

	/**
	 * Get the index of the points field in the csv file
	 * @return position of the points field as int
	 */
	public static int getIndexOfPoints() {
		return INDEX_OF_POINTS;
	}

	/**
	 * Get the file name prefix for 2015
	 * @return file name prefix as a string
	 */
	public static String get2015Prefix() {
		return PREFIX;
	}

	/**
	 * Get the csv suffix for a file
	 * @return .csv suffix as a string
	 */
	public static String getCsvSuffix() {
		return CSV_SUFFIX;
	}
}
