import java.io.FileReader;
import java.util.List;
import java.util.Iterator;

import com.opencsv.CSVReader;

@SuppressWarnings("unchecked")
class Main {
	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader(new FileReader("yea.csv"));
		List entries = reader.readAll();

		for(Iterator<String[]> i = entries.iterator(); i.hasNext();) {
			String[] s = i.next();
			for(String ss : s) {
				System.out.println(ss);
			}
		}
	}
}
