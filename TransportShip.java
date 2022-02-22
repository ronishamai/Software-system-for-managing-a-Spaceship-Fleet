package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends MySpaceship {
	static final int BASE_ANNUAL_MAINTENANCE_COST = 3000;

	private int cargoCapacity;
	private int passengerCapacity;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers,
			int cargoCapacity, int passengerCapacity) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity() {
		return this.cargoCapacity;

	}

	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return BASE_ANNUAL_MAINTENANCE_COST + this.getCargoCapacity() * 5 + this.getPassengerCapacity() * 3;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\n\tCargoCapacity=%d" + "\n\tPassengerCapacity=%d",
				this.getCargoCapacity(), this.getPassengerCapacity());
	}
}
