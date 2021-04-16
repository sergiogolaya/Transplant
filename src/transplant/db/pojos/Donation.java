package transplant.db.pojos;

public class Donation {
	private Integer id;
	private String name;
	private String type;
	
	public Donation(Integer id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
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
		if (!(donorlist).contains(donor)) {
			donor.addDonor(donor);
		}
	}
	public void removeDonor(Donor donor) {
		if(donorlist.contains(donor)) {
			donorlist.remove(donor);
		}
	}


}
