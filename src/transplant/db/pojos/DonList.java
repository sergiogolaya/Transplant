package transplant.db.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DonList")
@XmlType(propOrder = { "donors"})
public class DonList{
	
	@XmlElement
	private List<Donor> donors;
	
	public DonList(List<Donor> donors) {
		super();
		this.donors = donors;
	}
	
	public DonList() {
		super();
	}

	public List<Donor> getDonors() {
		return donors;
	}

	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}
	
	
}
