package transplant.ui;

import transplant.db.ifaces.DBManager;

import transplant.db.jdbc.JDBCManager;

import java.io.BufferedReader;
import java.io.IOException;
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


public class Menu {
	public static DBManager dbman = new JDBCManager();
	private static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	 public static int imprimirMenuHospital() {
		int opc=0;
		try {
		BufferedReader console= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n\nWELCOME TO SECOND LIFE\n\n");
		System.out.print("\n1.Add request");
		System.out.print("\n2.Check request");
		System.out.print("\nIntroduce an option\n");
		opc=Integer.parseInt(console.readLine());
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		return opc;
		
	}
	
	void imprimirMenuDP() {
		System.out.print("\n\nWELCOME TO SECOND LIFE\n\n");
		System.out.print("\n1.Check Request");
		System.out.print("\n3.Exit");
	
	}
	public static int imprimeMenu1Hospital() {
		//ADD REQUEST 
		int option=0;
		System.out.print("\nADD SECTION");
		System.out.print("\n1.Add patient");
		System.out.print("\n2.Add donor");
		System.out.print("\n3.Exit");
		System.out.print("\nIntroduce an option\n");
		try {
			BufferedReader console= new BufferedReader(new InputStreamReader(System.in));
			option=Integer.parseInt(console.readLine());
			
			}catch(IOException e) {
				e.printStackTrace();
			
			}
		return option;
	
	}
	public static int imprimeMenu2Hospital() {
		//CHECK REQUEST 
		int option=0;
		System.out.print("\nCHECK REQUEST SECTION");
		System.out.print("\n1.Delete request");
		System.out.print("\n2.Modify request");
		System.out.print("\n3.Exit");
		System.out.print("\nIntroduce an option\n");
		try {
			BufferedReader console= new BufferedReader(new InputStreamReader(System.in));
			option=Integer.parseInt(console.readLine());
			
			}catch(IOException e) {
				e.printStackTrace();
			
			}
		return option;
	
	}
	
	
	public static void main(String[] args) throws Exception {
		
		//HOSPITAL MENU
		int opc=imprimirMenuHospital();
		switch(opc) {
		case 1:  
			int opc2=imprimeMenu1Hospital();
			if(opc2==1)  addPatient();
			else if(opc2==2)  addDonor();
			else if(opc2==3);//Exit(0);
			break;
		case 2: 
			int opc3=imprimeMenu2Hospital();
			if (opc3==1);//remove requers
			else if (opc3==2);//modify r
			else if (opc3==3);//exit
			break;
		}
			
			
			
		
		
		
		
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
}
