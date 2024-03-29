package transplant.db.pojos;

import java.util.*;
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
import java.io.*;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="donation")
@XmlType(propOrder= {"id", "name", "type", "donationlist"})
public class Donation implements Serializable {
	
	
	private static final long serialVersionUID = -7136704596476565650L;
	@XmlAttribute
	private Integer id;
	@XmlElement
	private String name;
	@XmlElement
	private String type;
	@XmlElement(name = "donation")
	@XmlElementWrapper(name="donationlist")
	private List<Donation> donationlist;
	
	public Donation(Integer id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public Donation() {
		super();
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