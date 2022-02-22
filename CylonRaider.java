package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends MyBattleship {
	static final int BASE_ANNUAL_MAINTENANCE_COST = 3500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + BASE_ANNUAL_MAINTENANCE_COST + 500 * this.getCrewMembers().size()
				+ (int) (1200 * this.getMaximalSpeed());
	}
}
