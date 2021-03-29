package intercorp.retail.reto.util;

import java.util.Arrays;
import java.util.Date;

import org.joda.time.DateTime;

public class OperationUtils {

	public static double calculateAverage(int[] numbers) {
		return Arrays.stream(numbers).average().orElse(0);
	}

	public static double standardDeviation(int[] numbers) {
		double average = calculateAverage(numbers);
		double standardDeviation = 0.0;

		for (int number : numbers) {
			standardDeviation += Math.pow(number - average, 2);
		}
		return Math.sqrt(standardDeviation / numbers.length);
	}

	public static Date calculateDeathDate(Date birthDate, int lifeExpectancy) {
		DateTime dtOrg = new DateTime(birthDate);
		DateTime deathDate = dtOrg.plusYears(lifeExpectancy);
		return deathDate.toDate();
	}
}
