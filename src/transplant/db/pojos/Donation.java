package transplant.db.pojos;

import java.util.ArrayList;
import java.util.List;

public class Donation {
	private Integer id;
	private String name;
	private String type;
	private List<Donation> donationlist;
	
	public Donation(Integer id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	
	public Donation(String name, String type) {
		super();
		this.name = name;
		this.type = type;
		this.donationlist = new ArrayList <Donation>();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "organ [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
	public void addDonation(Donation donation) {
		if (!(donationlist).contains(donation)) {
			donationlist.add(donation);
		}
	}
	public void removeDonation(Donation donation) {
		if(donationlist.contains(donation)) {
			donationlist.remove(donation);
		}
	}


}
