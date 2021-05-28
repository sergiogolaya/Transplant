package transplant.db.pojos;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donor")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "donor")
@XmlType(propOrder = { "name", "gender", "age","donation_id" ,"mh_id","patientlist"  })
 /*@name
@GeneratedValue(generator="donor")
@TableGenerator(name="donor", table="sqlite_sequence",
    pkColumnName="name", valueColumnName="seq", pkColumnValue="departments")

@XmlAttribute
private String name;
@XmlElement
private String gender;
@XmlElement
private integer age;
@XmlElement
private integer donation_id;
@XmlElement
private integer mh_id;
@OneToMany(mappedBy="department")
@XmlElement(name = "donor")
@XmlElementWrapper(name = "donor")
private List <Patient> patientlist;*/

public class Donor implements Serializable{

	private static final long serialVersionUID = 1L;


	private String name;
	private String gender;
	private int age;
	private int donation_id;
	private int mh_id;
	private int id;
	private List<Patient> patientlist;
	private int userId;
	
	


	public Donor(List<Patient> patientlist) {
		super();
		this.patientlist = new ArrayList<Patient>();
	}
	
	public Donor(String name, String gender, int age, int donation_id, int mh_id, int id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.id = id;
		this.patientlist = new ArrayList<Patient>();
	}

	
	public Donor(String name, String gender, int age, int donation_id, int mh_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.patientlist = new ArrayList <Patient>();
	}
	

	public Donor(String name, String gender, int age, int donation_id, int mh_id, int id,
			int userId) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.donation_id = donation_id;
		this.mh_id = mh_id;
		this.id = id;
		this.patientlist = new ArrayList <Patient>();
		this.userId = userId;
	}

	public void addPatient(Patient p) {
		if (!patientlist.contains(p)) {
			patientlist.add(p);
		}
	}

	public void removePatient(Patient p) {
		if (patientlist.contains(p)) {
			patientlist.remove(p);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDonation_id() {
		return donation_id;
	}

	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}

	public int getMh_id() {
		return mh_id;
	}

	public void setMh_id(int mh_id) {
		this.mh_id = mh_id;
	}

	@Override
	public String toString() {
		return "Donor [name=" + name + ", gender=" + gender + ", age=" + age + ", donation_id=" + donation_id
				+ ", mh_id=" + mh_id + ", id=" + id + "]";
	}

}
