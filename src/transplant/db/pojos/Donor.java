package transplant.db.pojos;

import java.util.List;

public class Donor {

	private String name;
	private String gender;
	private int age;
	private int organ_id;
	private int mh_id;
	private String h_id;
	private int id;
	private List<Donor> donorlist;

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

	public int getOrgan_id() {
		return organ_id;
	}

	public void setOrgan_id(int organ_id) {
		this.organ_id = organ_id;
	}

	public int getMh_id() {
		return mh_id;
	}

	public void setMh_id(int mh_id) {
		this.mh_id = mh_id;
	}

	public String getH_id() {
		return h_id;
	}

	public void setH_id(String h_id) {
		this.h_id = h_id;
	}

	public void addDonor(Donor donor) {
		if (!(donorlist).contains(donor)) {
			donor.addDonor(donor);
		}
	}

	public void removeDonor(Donor donor) {
		if (donorlist.contains(donor)) {
			donorlist.remove(donor);
		}
	}

}
