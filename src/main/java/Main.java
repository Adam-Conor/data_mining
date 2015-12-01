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
@SuppressWarnings("unchecked")
public class Main {
	private static String name = "2015_9.csv";

	public static void main(String[] args) {
		Reader reader = new Reader(name);

		reader.readAll();
		int size = DataFormat.getMaxPlayers();

		Player[] players = new Player[size];

		for(int i = 0; i < size; i++) {
			players[i] = reader.getPlayer();
		}

		for(Player player : players) {
			System.out.println(player);
		}
	}
}
