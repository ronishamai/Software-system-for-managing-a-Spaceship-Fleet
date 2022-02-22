package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class MySpaceship implements Spaceship, Comparable<MySpaceship> {
	static final int BASE_FIRE_POWER = 10;

	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected Set<? extends CrewMember> crewMembers;

	public MySpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getCommissionYear() {
		return this.commissionYear;
	}

	@Override
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}

	@Override
	public int getFirePower() {
		return BASE_FIRE_POWER;
	}

	@Override
	public Set<? extends CrewMember> getCrewMembers() {
		return this.crewMembers;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "\n\t"
				+ String.format(
						"Name=%s\n\t" + "CommissionYear=%d\n\t" + "MaximalSpeed=%.1f\n\t" + "FirePower=%d\n\t"
								+ "CrewMembers=%d\n\t" + "AnnualMaintenanceCost=%d",
						this.getName(), this.getCommissionYear(), this.getMaximalSpeed(), this.getFirePower(),
						this.getCrewMembers().size(), this.getAnnualMaintenanceCost());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySpaceship other = (MySpaceship) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(MySpaceship other) {
		return this.getName().compareTo(other.getName());
	}
}
