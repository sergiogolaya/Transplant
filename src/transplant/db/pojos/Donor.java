package transplant.db.pojos;

import java.util.ArrayList;
import java.util.List;

public class Donor {

	private String name;
	private String gender;
	private int age;
	private int donation_id;
	private int mh_id;
	private int id;
	private List<Patient> patientlist;

	public Donor(List<Patient> patientlist) {
		super();
		this.patientlist = new ArrayList<Patient>();
	}
	
	public Donor(String name, String gender, int age, int donation_id, int mh_id, int id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.id = id;
		this.patientlist = new ArrayList<Patient>();
	}

	
	public Donor(String name, String gender, int age, int donation_id, int mh_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.patientlist = new ArrayList <Patient>();
	}

	public void addPatient(Patient p) {
		if (!patientlist.contains(p)) {
			patientlist.add(p);
		}
	}

	public void removePatient(Patient p) {
		if (patientlist.contains(p)) {
			patientlist.remove(p);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDonation_id() {
		return donation_id;
	}

	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}

	public int getMh_id() {
		return mh_id;
	}

	public void setMh_id(int mh_id) {
		this.mh_id = mh_id;
	}

	@Override
	public String toString() {
		return "Donor [name=" + name + ", gender=" + gender + ", age=" + age + ", donation_id=" + donation_id
				+ ", mh_id=" + mh_id + ", id=" + id + "]";
	}

}
