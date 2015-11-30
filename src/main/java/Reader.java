import java.util.List;
import java.io.FileReader;
import com.opencsv.CSVReader;

class Reader {
	private CSVReader reader;

	private @SuppressWarnings("unchecked")
	List data;

	private int indexOfName;
	private int indexOfPoints;

	private int tracker;
	
	public Reader(String fileName) {
	 	reader = new CSVReader(new FileReader(fileName));

		indexOfName = DataFormat.getIndexOfName();
		indexOfPoints = DataFormat.getIndexOfPoints();

		tracker = 0;
	}

	public void readAll() {
		data = reader.readAll();
	}

	public Player getPlayer() {
		String[] s = data.get(tracker);
		tracker++;

		String name = s[indexOfName];
		double avgPoints = Double.valueOf(s[indexOfPoints]);
		
		return new Player(name, avgPoints);
	}
}
