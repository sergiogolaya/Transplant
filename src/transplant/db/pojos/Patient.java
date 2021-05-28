package transplant.db.pojos;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Patient")
@XmlType(propOrder = { "gender", "age", "donation_id", "mh_id", "h_id" })

public class Patient implements Serializable {
	private static final long serialVersionUID = 3915252998504410580L;

	@Id
	@GeneratedValue(generator = "patients")
	@TableGenerator(name = "patients", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "employees")
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String gender;
	@XmlAttribute
	private Integer age;
	@XmlAttribute
	private Integer donation_id;
	@XmlAttribute
	private Integer mh_id;
	@XmlAttribute
	private String h_id;
	@XmlAttribute
	@ManyToMany(mappedBy = "authors")
	@XmlTransient
	private List<Donor> donorlist;
	@XmlElement
	@ManyToOne(fetch = FetchType.LAZY)
	@XmlTransient
	private List<Donation> donationlist;
	private Integer userId;

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

	public Patient(int id, String name, String gender, int age, int donation_id, int mh_id, String h_id) {
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

	public Patient(String name, String gender, Integer age, Integer donation_id, Integer mh_id, String h_id) {
		super();
		this.id= id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.h_id = h_id;
		this.donorlist = new ArrayList<Donor>();
		this.donationlist = new ArrayList<Donation>();
	}

	public Patient(String name, String gender, Integer age, Integer donation_id, Integer mh_id, String h_id,
			Integer userId) {
		super();
		this.id= id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.h_id = h_id;
		this.donorlist = new ArrayList<Donor>();
		this.donationlist = new ArrayList<Donation>();
		this.userId = userId;
	}

	public void addDonor(Donor d) {
		if (!donorlist.contains(d)) {
			donorlist.add(d);
		}
	}

	public void removeDonor(Donor d) {
		if (donorlist.contains(d)) {
			donorlist.remove(d);
		}
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

	public String getH_id() {
		return h_id;
	}

	public void setH_id(String h_id) {
		this.h_id = h_id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", donation_id="
				+ donation_id + ", mh_id=" + mh_id + ", h_id=" + h_id + "]";
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