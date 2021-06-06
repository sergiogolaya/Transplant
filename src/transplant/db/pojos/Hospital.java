package transplant.db.pojos;


import java.io.Serializable;
import javax.xml.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="hospital")
@XmlType(propOrder= {"idname", "city", "patientlist"})
public class Hospital implements Serializable{
	
	private static final long serialVersionUID = 6161233776001447765L;
	
	
	@XmlAttribute
	private String idname;
	@XmlElement
	private String city;
	@XmlElement(name="Patient")
	@XmlElementWrapper(name="Patient list")
	private List<Patient> patientlist;
	@XmlElement
	private int userId;
	
	
	
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
	
	
	public Hospital(String idname, String city, int userId) {
		super();
		this.idname = idname;
		this.city = city;
		this.patientlist = new ArrayList<Patient>();
		this.userId = userId;
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