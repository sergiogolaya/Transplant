package transplant.db.pojos;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private String idname;
	private String city;
	private List<Patient> patientlist;
	
	
	public Hospital(List<Patient> patientlist, List<Donor> donorlist) {
		super();
		this.patientlist = new ArrayList<Patient>();
	}
	public Hospital(String idname, String city) {
		super();
		this.idname = idname;
		this.city = city;
		this.patientlist = new ArrayList<Patient>();
	}
	public void addPatient(Patient p) {
		if(!patientlist.contains(p)) {
			patientlist.add(p);
		}
	}
	public void removePatient(Patient p) {
		if(patientlist.contains(p)) {
			patientlist.remove(p);
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
	@Override
	public String toString() {
		return "Hospital [idname=" + idname + ", city=" + city + ", patientlist=" + patientlist + "]";
	}
	
	
}
