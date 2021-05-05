package transplant.db.pojos;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private Integer donation_id;
	private Integer mh_id;
	private Integer h_id;
	private List<Donor> donorlist;
	private List<Donation> donationlist;

	public Patient() {
		super();
		this.donorlist = new ArrayList<Donor>();
		this.donationlist = new ArrayList<Donation>();
	}

	public Patient(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.donorlist = new ArrayList<Donor>();
		this.donationlist = new ArrayList<Donation>();
	}

	public Patient(Integer id, String name, String gender, Integer age, Integer donation_id, Integer mh_id,
			Integer h_id) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.h_id = h_id;
		this.donorlist = new ArrayList<Donor>();
		this.donationlist = new ArrayList<Donation>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getDonation_id() {
		return donation_id;
	}

	public void setDonation_id(Integer donation_id) {
		this.donation_id = donation_id;
	}

	public Integer getMh_id() {
		return mh_id;
	}

	public void setMh_id(Integer mh_id) {
		this.mh_id = mh_id;
	}

	public Integer getH_id() {
		return h_id;
	}

	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", donation_id="
				+ donation_id + ", mh_id=" + mh_id + ", h_id=" + h_id + ", donorlist=" + donorlist + ", donationlist="
				+ donationlist + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Patient other = (Patient) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
