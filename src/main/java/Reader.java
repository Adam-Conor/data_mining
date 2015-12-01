import java.util.regex.Pattern;
import java.util.List;
import java.io.FileReader;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class to wrap up the reader responsibilites
 * Uses OpenCSV
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-11-30
 * @see <a href="http://opencsv.sourceforge.net/">Open CSV</a>
 */
public class Reader {
	private CSVReader reader;

	@SuppressWarnings("unchecked")
		private List<String[]> data;

	private int indexOfName;
	private int indexOfPoints;
	private int indexOfRank;
	private int indexOfPrevRank;
	private int indexOfTotalPoints;
	private int indexOfDivisorEvents;
	private int indexOfActualEvents;
	private int indexOfTotalPointsGained;
	private int indexOfTotalPointsLost;

	private int csvPointer;

	/**
	 * Default all-args constructor
	 * initialises the pointer to 1 to ignore the headers and
	 * gets the indexes of the relevant columns specified in the {@link DataInfo} class.
	 * @param fileName name of the file to read as a string
	 */
	public Reader(String fileName) {
		try {
			reader = new CSVReader(new FileReader(fileName));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		indexOfName = DataInfo.getIndexOfName();
		indexOfPoints = DataInfo.getIndexOfPoints();
		indexOfRank = DataInfo.getIndexOfRank();
		indexOfPrevRank = DataInfo.getIndexOfPrevRank();
		indexOfTotalPoints = DataInfo.getIndexOfTotalPoints();
		indexOfDivisorEvents = DataInfo.getIndexOfDivisorEvents();
		indexOfActualEvents = DataInfo.getIndexOfActualEvents();
		indexOfTotalPointsGained = DataInfo.getIndexOfTotalPointsGained();
		indexOfTotalPointsLost = DataInfo.getIndexOfTotalPointsLost();

		csvPointer = 1;
	}

	/**
	 * Reads all the data into internal {@code List<String[]>}
	 * @see com.opencsv.CSVReader#readAll
	 */
	public void readAll() {
		try {
			data = reader.readAll();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the values from a player from the current position in the file
	 * Uses internal pointer to read in the next row
	 * Only reads the values specified by the {@link DataInfo} class
	 * @return Player with name and average points from csv file
	 */
	public Player getPlayer() {
		String[] s = data.get(csvPointer);
		csvPointer++;

		String name = s[indexOfName];
		double avgPoints = Double.valueOf(s[indexOfPoints]);
		double rank = Double.valueOf(s[indexOfRank]);
		double prevRank = trimParens(s[indexOfPrevRank]);
		double totalPoints = Double.valueOf(s[indexOfTotalPoints]);
		double divisorEvents = Double.valueOf(s[indexOfDivisorEvents]);
		double actualEvents = Double.valueOf(s[indexOfActualEvents]);
		double totalPointsGained = Double.valueOf(s[indexOfTotalPointsGained]);
		double totalPointsLost = Double.valueOf(s[indexOfTotalPointsLost]);

		return new Player(name, avgPoints, rank, prevRank, 
				totalPoints, divisorEvents, actualEvents, totalPointsGained, totalPointsLost);
	}

	private double trimParens(String prevRank) {
		prevRank = prevRank.replace("(", "");
		prevRank = prevRank.replace(")", "");

		return Double.valueOf(prevRank);
	}
}
