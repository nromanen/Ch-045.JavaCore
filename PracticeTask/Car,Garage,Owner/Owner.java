package forExam;

public class Owner {
	private String lastName;
	private String firstName;
	private String adress;
	private int phoneNumber;

	public Owner() {
	}

	public Owner(String lastName, String firstName, int phoneNumber, String adress) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + ", you can contact me " + getPhoneNumber() + " by adress: "
				+ getAdress();
	}

}
