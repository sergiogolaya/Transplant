package transplant.db.pojos;

public class Hospital {
	private String idname;
	private String city;
	
	
	public Hospital(String idname, String city) {
		super();
		this.idname = idname;
		this.city = city;
	}
	public void addPatient(Patient p) {
		if(!patientlist.contains(p)) {
			patientlist.add(p);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((idname == null) ? 0 : idname.hashCode());
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
		Hospital other = (Hospital) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (idname == null) {
			if (other.idname != null)
				return false;
		} else if (!idname.equals(other.idname))
			return false;
		return true;
	}

	public String getIdname() {
		return idname;
	}
	public void setIdname(String idname) {
		this.idname = idname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
