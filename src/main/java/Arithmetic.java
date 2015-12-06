/**
 * Class for handling the arithmetic in the assignemnt
 * All work is our own
 * @author Conor Smyth <conor.smyth39@mail.dcu.ie>
 * @author Adam O'Flynn <adam.oflynn7@mail.dcu.ie>
 * @since 2015-12-06
 */
class Arithmetic {

	/**
	 * Get the range of the array supplied
	 * Array does not need to be sorted
	 * @param numberArray double array of numbers
	 * @return max - min of the data
	 */
	public Double range(Double[] numberArray) {
		Double largest = 0.0;
		Double smallest = -1.0;

		for(int i = 0; i < numberArray.length; i++) {
			if(numberArray[i] < smallest) {
				smallest = numberArray[i];
			}

			if(numberArray[i] > largest) {
				largest = numberArray[i];
			}
		}

		return largest - smallest;
	}

	/**
	 * Get the median in the double array supplied
	 * Array must be ordered highest to lowest
	 * @param numberArray double array of number
	 * @return the median value in the data
	 */
	public static Double median(Double[] numberArray) {
		Integer length = numberArray.length;

		if(!isEven(length)) {
			return numberArray[length / 2];
		} else {
			Double x = numberArray[(length / 2) - 1];
			Double y = numberArray[(length / 2) + 1];

			return (x + y) / 2;
		}
	}

	/**
	 * Checks if the number supplied is even
	 * @param x number to check
	 * @return true if number is even
	 */
	private static boolean isEven(Integer x) {
		return x % 2 == 0;
	}

	/**
	 * Get the upper quartile of the double array supplied
	 * Array must be ordered highest to lowest
	 * @param numberArray the double array to get the upper quartile
	 * @return the upper quartile as a double
	 */
	public static Double upperQ(Double[] numberArray) {
		Double median = median(numberArray);
		Double[] upper = new Double[numberArray.length / 2];

		for(int i = 0; i < upper.length; i++) {
			upper[i] = numberArray[i];
		}

		Double upperMedian = median(upper);

		return upperMedian;
	}

	/**
	 * Get the lower quartile of the double array supplied
	 * Array must be ordered highest to lowest
	 * @param numberArray the double array to get the lower quartile
	 * @return the lower quartile as a double
	 */
	public static Double lowerQ(Double[] numberArray) {
		Double median = median(numberArray);
		Double lower[] = new Double[numberArray.length / 2];

		for(int i = 0; i < lower.length; i++) {
			lower[i] = numberArray[i + numberArray.length / 2];
		}

		Double lowerMedian = median(lower);

		return lowerMedian;
	}

	/**
	 * Get the min value in the double array supplied
	 * @param numberArray double array to get the min
	 * @return minimum value of the array as a double
	 */
	public static Double min(Double[] numberArray) {
		Double min = 0.0;

		for(int i = 0; i < numberArray.length; i++) {
			if(numberArray[i] < min) {
				min = numberArray[i];
			}
		}

		return min;
	}

	/**
	 * Get the max value in the double array supplied
	 * @param numberArray double array to get the max
	 * @return maximum value of the array as a double
	 */
	public static Double max(Double[] numberArray) {
		Double max = 0.0;

		for(int i = 0; i < numberArray.length; i++) {
			if(numberArray[i] > max) {
				max = numberArray[i];
			}
		}

		return max;
	}

	/**
	 * Get the IQR range of the double array supplied
	 * Array must be ordered highest to lowest
	 * @param numberArray double array of numbers
	 * @return IQR of the data as a double
	 */
	public static Double iqr(Double[] numberArray) {
		Double lower = lowerQ(numberArray);
		Double upper = upperQ(numberArray);

		return upper - lower;
	}
}
