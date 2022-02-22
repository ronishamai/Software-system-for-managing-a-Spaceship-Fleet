package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in
	 * descending order by fire power, and then in descending order by commission
	 * year, and finally in ascending order by name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
		List<Spaceship> spaceships = new ArrayList<Spaceship>(fleet);
		Collections.sort(spaceships, new MySpaceshipComparator());
		return spaceships.stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the
	 * number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> res = new HashMap<String, Integer>();
		for (Spaceship s : fleet) {
			String className = s.getClass().getSimpleName();
			int count = res.getOrDefault(className, 0);
			res.put(className, count + 1);
		}
		return res;

	}

	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of
	 * maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship s : fleet) {
			sum += s.getAnnualMaintenanceCost();
		}
		return sum;
	}

	/**
	 * Returns a set containing the names of all the fleet's weapons installed on
	 * any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weapons = new HashSet<String>();
		for (Spaceship s : fleet) {
			if (!(s instanceof MyBattleship)) {
				continue;
			}

			for (Weapon w : ((MyBattleship) s).getWeapon()) {
				weapons.add(w.getName());
			}
		}
		return weapons;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given
	 * fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int res = 0;
		for (Spaceship s : fleet) {
			res += s.getCrewMembers().size();
		}
		return res;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's
	 * ships.
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int officerCount = 0;
		float ageSum = 0;
		for (Spaceship s : fleet) {
			Set<? extends CrewMember> crew = s.getCrewMembers();
			for (CrewMember m : crew) {
				if (!(m instanceof Officer)) {
					continue;
				}
				officerCount++;
				ageSum += m.getAge();
			}
		}
		return ageSum / officerCount;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to
	 * his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> res = new HashMap<Officer, Spaceship>();

		for (Spaceship s : fleet) {
			List<Officer> officers = s.getCrewMembers().stream().filter(m -> m instanceof Officer).map(m -> (Officer) m)
					.collect(Collectors.toList());
			officers.sort((Officer o1, Officer o2) -> {
				return o1.getRank().compareTo(o2.getRank()) * -1;
			});

			if (officers.size() > 0) {
				res.put(officers.get(0), s);
			}
		}

		return res;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences. Each
	 * entry represents a pair composed of an officer rank, and the number of its
	 * occurrences among starfleet personnel. The returned list is sorted
	 * ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankPopularity = new HashMap<OfficerRank, Integer>();
		// Populate rankPopularity
		for (Spaceship s : fleet) {
			List<Officer> officers = s.getCrewMembers().stream().filter(m -> m instanceof Officer).map(m -> (Officer) m)
					.collect(Collectors.toList());
			officers.forEach(o -> {
				OfficerRank rank = o.getRank();
				int curPopularity = rankPopularity.getOrDefault(rank, 0);
				rankPopularity.put(rank, curPopularity + 1);
			});
		}

		List<Map.Entry<OfficerRank, Integer>> entries = new ArrayList<Map.Entry<OfficerRank, Integer>>(
				rankPopularity.entrySet());
		// Sort rankPopularity entries by popularity or rank
		entries.sort((Map.Entry<OfficerRank, Integer> e1, Map.Entry<OfficerRank, Integer> e2) -> {
			int res = e1.getValue().compareTo(e2.getValue());
			if (res != 0) {
				return res;
			}
			return e1.getKey().compareTo(e2.getKey());
		});

		return entries;
	}

}
