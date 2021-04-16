package transplant.db.pojos;

import java.util.List;

public class Patient {
	private int id;
	private String name;
	private String gender;
	private int age;
	private List<Patient> patientlist;
	
	public void addPatient(Patient p) {
		if(!(patientlist).contains(p)) {
			patientlist.add(p);
		}
	}
	
	public void removePatient(Patient p) {
		if(patientlist.contains(p)) {
			patientlist.remove(p);
		}
	}

	public Patient(int id, String name, String gender, int age, List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		patientlist = patients;
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

	public List<Patient> getPatients() {
		return patientlist;
	}

	public void setPatients(List<Patient> patients) {
		patientlist = patients;
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

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", Patients=" + patientlist
				+ "]";
	}
	
	

}
