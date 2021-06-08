package transplant.db.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PatList")
@XmlType(propOrder = { "pats"})
public class PatList{

	@XmlElement
	private List<Patient> pats;
	
	public PatList(List<Patient> pats) {
		super();
		this.pats = pats;
	}
	
	public PatList() {
		super();
	}

	public List<Patient> getPatient() {
		return pats;
	}

	public void setPatients(List<Patient> pats) {
		this.pats = pats;
	}
}
