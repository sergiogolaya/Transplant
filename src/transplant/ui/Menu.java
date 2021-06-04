package transplant.ui;

import transplant.db.ifaces.DBManager;

import transplant.db.jdbc.JDBCManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import transplant.db.ifaces.UserManager;
import transplant.db.jpa.JPAUserManager;
import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;
import transplant.db.pojos.Donation;
import transplant.db.pojos.Donor;
import transplant.db.pojos.Hospital;
import transplant.db.pojos.M_h;
import transplant.db.pojos.Patient;
import transplant.db.pojos.Request;
import transplant.db.pojos.users.Role;
import transplant.db.pojos.users.User;

public class Menu {
	public static DBManager dbman = new JDBCManager();
	private static UserManager userman = new JPAUserManager();

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	

	
	public static void main(String[] args) throws Exception  {
		dbman.connect();
		userman.connect();
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		String aux;
		System.out.println("\n\n         WELCOME TO SECOND LIFE\n\n");
		System.out.println("\n1.Register");
		System.out.println("\n2. Log in");
		System.out.println("\n3. Exit");
		System.out.println("\nIntroduce your option: ");
		aux=console.readLine();
		option=Integer.parseInt(aux);
		switch (option) {
		case 1:
			register();
			break;
		case 2:
			logIn();
			break;
		case 3:
			dbman.disconnect();
			userman.disconnect();
			System.exit(0);
		default:
			break;

		}

	}

	private static void register() throws NumberFormatException, IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		System.out.println("Specify your profile: 1.Patient  2. Donor   3. Hospital");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int profile = Integer.parseInt(console.readLine());

		switch (profile) {
		case 1:
			registerPatient();
			break;
		case 2:
			registerDonor();
			break;
		case 3:
			registerHospital();
			break;
		}
	}

	private static void logIn() throws Exception {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please, introduce your email: ");
		String email = console.readLine();
		System.out.println("Please, introduce your password: ");
		String password = console.readLine();
		User u = userman.checkPassword(email, password);
		if (u == null) {
			System.out.println("Wrong email or password");
		} else if (u.getRole().getName().equalsIgnoreCase("patient")) {
			patientMenu(u);
		}

		else if (u.getRole().getName().equalsIgnoreCase("donor")) {
			donorMenu(u);
		} else if (u.getRole().getName().equalsIgnoreCase("hospital")) {
			hospitalMenu(u);
		}

	}

	private static void hospitalMenu(User u) throws Exception {
		// TODO Auto-generated method stub
		int option = 0;
		System.out.println("\nChoose an option: ");
		System.out.print("\n1.Add patient");
		System.out.print("\n2.Add donor");
		System.out.print("\n3.Delete request");
		System.out.print("\n3.Modify request");
		System.out.print("\n5.Exit");
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(console.readLine());

		} catch (IOException e) {
			e.printStackTrace();

		}
		switch (option) {
		case 1:
			addPatient();
			break;

		case 2:
			addDonor();
			break;

		case 3:
			deleteRequest();
			break;

		case 4:
			modifyPatientAge();
			break;

		case 5:
			break;
		}

	}

	private static void donorMenu(User u) throws Exception {
		// TODO Auto-generated method stub
		int option = 0;
		System.out.println("\nChoose an option: ");
		System.out.println("\n1. Check your request");
		System.out.println("\n2. Exit");
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(console.readLine());

		} catch (IOException e) {
			e.printStackTrace();

		}
		switch (option) {
		case 1:
			searchDonor();
			break;
		case 2:
			break;
		}
	}

	private static void patientMenu(User u) throws Exception {
		// TODO Auto-generated method stub
		int option=0;
		System.out.println("\nChoose an option: ");
		System.out.println("\n1. Check your request");
		System.out.println("\n2. Exit");
		try {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			option = Integer.parseInt(console.readLine());

		} catch (IOException e) {
			e.printStackTrace();

		}
		switch (option) {
		case 1:
			searchPatient();
			break;
		case 2:
			break;
		}

	}

	private static void registerPatient() throws IOException, NoSuchAlgorithmException {
		System.out.println("Please, choose an email: ");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String email = console.readLine();
		System.out.println("Please, choose a password: ");
		String password = console.readLine();
		Role role = userman.getRole(2);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] hash = md.digest();
		User u = new User(email, hash, role);
		userman.newUser(u);
		addPatientU(u.getId());

	}

	private static void registerDonor() throws IOException, NoSuchAlgorithmException {
		System.out.println("Please, choose an email: ");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String email = console.readLine();
		System.out.println("Please, choose a password: ");
		String password = console.readLine();
		Role role = userman.getRole(3);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] hash = md.digest();
		User u = new User(email, hash, role);
		userman.newUser(u);
		addDonorU(u.getId());

	}

	private static void registerHospital() throws IOException, NoSuchAlgorithmException {
		System.out.println("Please, choose an email: ");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String email = console.readLine();
		System.out.println("Please, choose a password: ");
		String password = console.readLine();
		Role role = userman.getRole(1);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] hash = md.digest();
		User u = new User(email, hash, role);
		userman.newUser(u);
		addHospitalU(u.getId());

	}

	private static void addPatientU(Integer userId) throws IOException {
		String aux;
		System.out.println("Please, input the patient info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Patient name: ");
		String patientname = reader.readLine();
		System.out.print("Gender: ");
		String patientgender = reader.readLine();
		System.out.print("Age: ");
		aux = reader.readLine();
		Integer patientage = Integer.parseInt(aux);
		System.out.print("Donation id: ");
		aux = reader.readLine();
		Integer donation_id = Integer.parseInt(aux);
		System.out.print("Medical History id: ");
		aux = reader.readLine();
		Integer medical_history = Integer.parseInt(aux);
		System.out.print("Hospital id: ");
		String hospital_id = reader.readLine();
		Patient p = new Patient(patientname, patientgender, patientage, donation_id, medical_history, hospital_id,
				userId);
		dbman.addPatient(p);

	}

	private static void addPatient() throws Exception {

		String aux;
		System.out.println("Please, input the patient info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Patient name: ");
		String patientname = reader.readLine();
		System.out.print("Gender: ");
		String patientgender = reader.readLine();
		System.out.print("Age: ");
		aux = reader.readLine();
		Integer patientage = Integer.parseInt(aux);
		System.out.print("Donation id: ");
		aux = reader.readLine();
		Integer donation_id = Integer.parseInt(aux);
		System.out.print("Medical History id: ");
		aux = reader.readLine();
		Integer medical_history = Integer.parseInt(aux);
		System.out.print("Hospital id: ");
		String hospital_id = reader.readLine();
		Patient p = new Patient(patientname, patientgender, patientage, donation_id, medical_history, hospital_id);
		dbman.addPatient(p);
	}

	private static void addDonorU(Integer userId) throws IOException {
		String aux;
		System.out.println("Please, input the donor info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Donor name: ");
		String donorname = reader.readLine();
		System.out.print("Gender: ");
		String donorgender = reader.readLine();
		System.out.print("Age: ");
		aux = reader.readLine();
		Integer donorage = Integer.parseInt(aux);
		System.out.print("Donation id: ");
		aux = reader.readLine();
		Integer donation_id = Integer.parseInt(aux);
		System.out.print("Medical History id: ");
		aux = reader.readLine();
		Integer medical_history = Integer.parseInt(aux);
		Donor d = new Donor(donorname, donorgender, donorage, donation_id, medical_history, userId);
		dbman.addDonor(d);

	}

	private static void addDonor() throws Exception {
		String aux;
		System.out.println("Please, input the donor info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Donor name: ");
		String donorname = reader.readLine();
		System.out.print("Gender: ");
		String donorgender = reader.readLine();
		System.out.print("Age: ");
		aux = reader.readLine();
		Integer donorage = Integer.parseInt(aux);
		System.out.print("Donation id: ");
		aux = reader.readLine();
		Integer donation_id = Integer.parseInt(aux);
		System.out.print("Medical History id: ");
		aux = reader.readLine();
		Integer medical_history = Integer.parseInt(aux);
		Donor d = new Donor(donorname, donorgender, donorage, donation_id, medical_history);
		dbman.addDonor(d);

	}

	private static void addHospitalU(Integer userId) throws IOException {
		String aux;
		System.out.println("Please, input the hospital info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Hospital name: ");
		String hospitalname = reader.readLine();
		System.out.print("City: ");
		String city = reader.readLine();
		Hospital h = new Hospital(hospitalname, city, userId);
		dbman.addHospital(h);

	}

	private static void addHospital() throws Exception {
		System.out.println("Please, input the hospital info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("id name: ");
		String idname = reader.readLine();
		System.out.print("city: ");
		String city = reader.readLine();
		Hospital h = new Hospital(idname, city);
		dbman.addHospital(h);
	}
	// dbman.connect();

	// addPatient();
	/*
	 * addDonor(); addHospital(); addDonation(); addMedicalHistory(); addRequest();
	 * searchDonor();
	 */

	// modifyPatientAge();

	// addPatient();
	// addDonor();
	// addHospital();
	// addDonation();
	// addMedicalHistory();
	// addRequest();
	// searchDonor();
	// dbman.printRequests();
	// deleteRequest();
	// dbman.disconnect();

	private static void addDonation() throws Exception {
		System.out.println("Please, input the donation info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("type: ");
		String type = reader.readLine();
		System.out.print("name: ");
		String name = reader.readLine();
		Donation don = new Donation(name, type);
		dbman.addDonation(don);

	}

	public static void addMedicalHistory() throws Exception {

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
		M_h mh = new M_h(bloodtype, previous_illnesses, actual_illnesses, Date.valueOf(date));
		dbman.addMedicalHistory(mh);
	}

	public static void addRequest() throws Exception {
		String aux;
		System.out.println("Please, input the Request info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Patient id: ");
		aux = reader.readLine();
		Integer patient_id = Integer.parseInt(aux);
		System.out.print("Donor id: ");
		aux = reader.readLine();
		Integer donor_id = Integer.parseInt(aux);

		Request r = new Request(patient_id, donor_id);
		dbman.addRequest(r);
	}

	private static void deleteRequest() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		dbman.printRequests();
		System.out.println("Please, input the patient request id:");
		String aux = reader.readLine();
		Integer p_id = Integer.parseInt(aux);
		System.out.println("Please, input the donor request id:");
		aux = reader.readLine();
		Integer d_id = Integer.parseInt(aux);
		dbman.deleteRequest(p_id, d_id);
		dbman.printRequests();
	}

	private static void searchPatient() throws Exception {
		System.out.println("Please, input the search term:");
		System.out.print("Patient id: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String aux = reader.readLine();
		Integer id = Integer.parseInt(aux);
		List<Patient> patients = dbman.searchPatientById(id);
		if (patients.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(patients);
		}
	}

	private static void searchDonor() throws Exception {
		System.out.println("Please, input the search term:");
		System.out.print("Donor id: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String aux = reader.readLine();
		Integer id = Integer.parseInt(aux);
		List<Donor> donors = dbman.searchDonorById(id);
		if (donors.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(donors);
		}
	}

	private static void modifyPatientAge() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose a patient, type its id: ");
		dbman.printRequests();
		Integer id = Integer.parseInt(reader.readLine());
		System.out.print("Type the new age of the patient: ");
		String aux = reader.readLine();
		Integer newAge = Integer.parseInt(aux);
		dbman.modifyPatient(id, newAge);
		System.out.println("Update finished.");
	}

}
