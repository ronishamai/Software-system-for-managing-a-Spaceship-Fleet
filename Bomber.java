package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends MyBattleship {
	static final int BASE_ANNUAL_MAINTENANCE_COST = 5000;

	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers,
			List<Weapon> weapons, int numberOfTechnicians) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		float techniciansDiscount = (1 - (float) this.numberOfTechnicians * 10 / 100);

		return BASE_ANNUAL_MAINTENANCE_COST + (int) (super.getAnnualMaintenanceCost() * techniciansDiscount);
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\n\tNumberOfTechnicians=%d", this.getNumberOfTechnicians());
	}

}
