import java.io.FileReader;
import java.util.List;
import java.util.Iterator;

import com.opencsv.CSVReader;

/**
	Name files: yyyy_w? eg 2015_9 for year 2015 and week 9
	index 0 is the header i.e s[0];
	index 1..N is the values for each i.e s[1..N]
*/

@SuppressWarnings("unchecked")
class Main {
	private static String name = "2015_9";

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader(name);

		reader.readAll();

		Player p = reader.getPlayer();

		System.out.println(p);
	}
}
