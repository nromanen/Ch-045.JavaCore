package homework2ndtask;

public enum Rate {
	BEGINNER(1), ADVANCED(1.5), PROFI(2), CONTRACT_BEGINNER(10), CONTRACT_ADVANCED(15), CONTRACT_PROFI(20);

	public  double skillsRate;

	Rate(double skillsRate) {
		this.skillsRate = skillsRate;
	}

	public  double getSkillsRate() {
		return skillsRate;
	}

	public void setSkillsRate(double skillsRate) {
		this.skillsRate = skillsRate;
	}

}
