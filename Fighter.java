package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MyBattleship {
	static final int BASE_ANNUAL_MAINTENANCE_COST = 2500;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + BASE_ANNUAL_MAINTENANCE_COST + (int) (this.getMaximalSpeed() * 1000);
	}
}
