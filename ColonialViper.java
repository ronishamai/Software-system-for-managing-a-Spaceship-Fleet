package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends MyBattleship {
	static final int BASE_ANNUAL_MAINTENANCE_COST = 4000;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + BASE_ANNUAL_MAINTENANCE_COST + 500 * this.getCrewMembers().size()
				+ (int) (500 * this.getMaximalSpeed());
	}
}
