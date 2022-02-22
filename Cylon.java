package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends MyCrewMember {
	private int modelNumer;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		this.age = age;
		this.yearsInService = yearsInService;
		this.name = name;
	}

	public int getModelNumber() {
		return this.modelNumer;
	}
}
