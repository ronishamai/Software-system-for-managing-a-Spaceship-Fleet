package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class MyCrewMember implements CrewMember, Comparable<MyCrewMember> {
	protected String name;
	protected int age;
	protected int yearsInService;

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getYearsInService() {
		return this.yearsInService;
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
		MyCrewMember other = (MyCrewMember) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
    public int compareTo(MyCrewMember other) {
		return this.getName().compareTo(other.getName());
	}
}
