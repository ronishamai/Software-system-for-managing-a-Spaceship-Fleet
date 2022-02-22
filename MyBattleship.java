package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MyBattleship extends MySpaceship {
	protected List<Weapon> weapons;

	public MyBattleship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = weapons;
	}

	@Override
	public int getFirePower() {
		int weaponsFirePower = 0;
		for (Weapon w : this.getWeapon()) {
			weaponsFirePower += w.getFirePower();
		}

		return super.getFirePower() + weaponsFirePower;
	}

	public List<Weapon> getWeapon() {
		return this.weapons;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int weaponsAnnualMaintenanceCost = 0;
		for (Weapon w : this.getWeapon()) {
			weaponsAnnualMaintenanceCost += w.getAnnualMaintenanceCost();
		}

		return weaponsAnnualMaintenanceCost;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\n\tWeaponArray=%s",
				this.getWeapon().stream().map(w -> w.toString()).collect(Collectors.toList()));
	}
}
