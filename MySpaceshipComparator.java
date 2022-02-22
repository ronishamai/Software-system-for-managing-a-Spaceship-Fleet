package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

/**
 * Compare by sorted in descending order by fire power, and then in descending
 * order by commission year, and finally in ascending order by name
 */
public class MySpaceshipComparator implements Comparator<Spaceship> {

	@Override
	public int compare(Spaceship o1, Spaceship o2) {
		int res = Integer.compare(o1.getFirePower(), o2.getFirePower()) * -1;
		if (res != 0) {
			return res;
		}

		res = Integer.compare(o1.getCommissionYear(), o2.getCommissionYear()) * -1;
		if (res != 0) {
			return res;
		}

		return o1.getName().compareTo(o2.getName());
	}

}
