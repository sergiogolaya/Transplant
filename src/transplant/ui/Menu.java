package transplant.ui;

import transplant.db.ifaces.DBManager;

import transplant.db.jdbc.JDBCManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;
import transplant.db.pojos.Donation;
import transplant.db.pojos.Donor;
import transplant.db.pojos.Hospital;
import transplant.db.pojos.M_h;
import transplant.db.pojos.Patient;
import transplant.db.pojos.Request;


public class Menu {
	public static DBManager dbman = new JDBCManager();
	private static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static void main(String[] args) throws Exception {
		dbman.connect();
		//addPatient();
		//addDonor();
		//addHospital();
		//addDonation();
		//addMedicalHistory();
		//addRequest();
		searchDonor();
		dbman.disconnect();
		}
private static void addPatient() throws Exception{
	
	String aux;
	System.out.println("Please, input the patient info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Patient name: ");
	String patientname = reader.readLine();
	System.out.print("Gender: ");
	String patientgender = reader.readLine();
	System.out.print("Age: ");
	aux = reader.readLine();
	Integer patientage=Integer.parseInt(aux);
	System.out.print("Donation id: ");
	aux = reader.readLine();
	Integer donation_id=Integer.parseInt(aux);
	System.out.print("Medical History id: ");
	aux = reader.readLine();
	Integer medical_history=Integer.parseInt(aux);
	System.out.print("Hospital id: ");
	String hospital_id= reader.readLine();
	Patient p= new Patient (patientname,patientgender,patientage,donation_id,medical_history,hospital_id);
	dbman.addPatient(p);
}
private static void addDonor() throws Exception{
	String aux;
	System.out.println("Please, input the donor info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Donor name: ");
	String donorname = reader.readLine();
	System.out.print("Gender: ");
	String donorgender = reader.readLine();
	System.out.print("Age: ");
	aux = reader.readLine();
	Integer donorage=Integer.parseInt(aux);
	System.out.print("Donation id: ");
	aux = reader.readLine();
	Integer donation_id=Integer.parseInt(aux);
	System.out.print("Medical History id: ");
	aux = reader.readLine();
	Integer medical_history=Integer.parseInt(aux);
	Donor d= new Donor (donorname,donorgender,donorage,donation_id,medical_history);
	dbman.addDonor(d);
	
}
private static void addHospital() throws Exception{
	System.out.println("Please, input the hospital info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("id name: ");
	String idname = reader.readLine();
	System.out.print("city: ");
	String city = reader.readLine();
	Hospital h=new Hospital(idname,city);
	dbman.addHospital(h);

}
private static void addDonation() throws Exception{
	System.out.println("Please, input the donation info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("type: ");
	String type = reader.readLine();
	System.out.print("name: ");
	String name = reader.readLine();
	Donation don =new Donation(name,type);
	dbman.addDonation(don);
	
}
public static void addMedicalHistory() throws Exception{
	
	System.out.println("Please, input the MedicalHistory info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Blood type: ");
	String bloodtype = reader.readLine();
	System.out.print("Previous illnesses: ");
	String previous_illnesses = reader.readLine();
	System.out.print("Actual illnesses: ");
	String actual_illnesses = reader.readLine();
	System.out.print("Date (yyyy-MM-dd): ");
	LocalDate date = LocalDate.parse(reader.readLine(), formatter);
	M_h mh=new M_h(bloodtype,previous_illnesses,actual_illnesses, Date.valueOf(date));
	dbman.addMedicalHistory(mh);
}
public static void addRequest() throws Exception{
	String aux;
	System.out.println("Please, input the Request info:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Patient id: ");
	aux = reader.readLine();
	Integer patient_id=Integer.parseInt(aux);
	System.out.print("Donor id: ");
	aux = reader.readLine();
	Integer donor_id=Integer.parseInt(aux);
	
	Request r=new Request(patient_id,donor_id);
	dbman.addRequest(r);
}
private static void searchPatient() throws Exception {
	System.out.println("Please, input the search term:");
	System.out.print("Patient id: ");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String aux= reader.readLine();
	Integer id=Integer.parseInt(aux);
	List<Patient> patients = dbman.searchPatientById(id);
	if (patients.isEmpty()) {
		System.out.println("No results.");
	}
	else {
		System.out.println(patients);
	}
}
private static void searchDonor() throws Exception {
	System.out.println("Please, input the search term:");
	System.out.print("Donor id: ");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String aux= reader.readLine();
	Integer id=Integer.parseInt(aux);
	List<Donor> donors = dbman.searchDonorById(id);
	if (donors.isEmpty()) {
		System.out.println("No results.");
	}
	else {
		System.out.println(donors);
	}
}

}
