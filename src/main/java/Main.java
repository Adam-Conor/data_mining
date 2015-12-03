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
	private static final String root = "/home/conor/Dropbox/college/comp_sci/data_mining/2015_csvs/";

	public static void main(String[] args) {
		Week[] weeks = new Week[48];

		for(int i = 0; i < weeks.length; i++) {
			weeks[i] = getWeek(i + 1);
		}

		Player[] testArray = new Player[weeks.length];
		int pointer = 0;

		String name = weeks[pointer].getPlayer(0).getName();
		int[] weekNo = new int[48];
		int i = 0;

		for(Week w : weeks) {
			testArray[pointer] = w.getPlayer(name);
			weekNo[i] = w.getWeekNumber();
			i++;
			pointer++;
		}

		i = 0;

		for(Player p : testArray) {
			System.out.println("Week: " + weekNo[i] + p);
			i++;
		}
	}

	private static Week getWeek(int weekNumber) {
		String fileName = root + DataInfo.get2015Prefix() + weekNumber + DataInfo.getCsvSuffix();

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
}
