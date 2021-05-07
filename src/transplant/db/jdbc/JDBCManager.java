package transplant.db.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import transplant.db.ifaces.DBManager;
import transplant.db.pojos.Donor;
import transplant.db.pojos.Patient;




public class JDBCManager implements DBManager {

	private Connection c;
	public void connect() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/transplant.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			this.createTables();
		} catch (SQLException sqlE) {
			System.out.println("There was a database exception.");
			sqlE.printStackTrace();
		} catch (Exception e) {
			System.out.println("There was a general exception.");
			e.printStackTrace();
		}
	}

	private void createTables() {
	
		try {
           
			Statement stm1= c.createStatement();
		
		    String sql1="CREATE TABLE patient( "
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "name TEXT NOT NULL,"
				      + "gender TEXT NOT NULL,"
				      + "age INTEGER NOT NULL,"
				      + "organ_ID INTEGER NOT NULL,"
				      + "MH_ID INTEGER NOT NULL,"
				      + "H_ID INTEGER NOT NULL)";		    
		   stm1.executeUpdate(sql1);
		  
		     sql1="CREATE TABLE donor( "
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "name TEXT NOT NULL,"
				      + "gender TEXT NOT NULL,"
				      + "age INTEGER NOT NULL,"
				      + "organ_ID INTEGER NOT NULL,"
				      + "MH_ID INTEGER NOT NULL)";				
		   stm1.executeUpdate(sql1);
		 
		     sql1="CREATE TABLE hospital( "
				      + "id TEXT PRIMARY KEY ,"
				      + "city TEXT NOT NULL)";
				      
		   stm1.executeUpdate(sql1);
		     sql1="CREATE TABLE donation( "
				      + "type TEXT NOT NULL,"
				      + "name TEXT NOT NULL)";
				      
		   stm1.executeUpdate(sql1);
		   
		   
			
		     sql1="CREATE TABLE MH ("
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "blood_type TEXT," 
				      + "p_illnesses TEXT,"
				      + "a_illnesses TEXT,"
				      + "date LOCALDATE)";
		   
		    stm1.executeUpdate(sql1);
		    
			
		     sql1="CREATE TABLE request( "
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
		    		  + "match BOOLEAN)";
				      
		   stm1.executeUpdate(sql1);
		   
		    sql1="CREATE TABLE relationship( "
				      + "patient_id INTEGER,"
		    		  + "donor_id INTEGER,"
				      + "PRIMARY KEY(patient_id, donor_id))";
				      
		   stm1.executeUpdate(sql1);		   
		   stm1.close();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("TABLAS");
		}

	}

	public void deletePatient(int patient_id) {
		try {
			String sql = "DELETE FROM patient WHERE id = ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient_id);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDonor(int donor_id) {
		try {
			String sql = "DELETE FROM donor WHERE id = ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, donor_id);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPatient() {
		try {
			String aux;
			// TODO TENDREMOS QUE HACER UN METODO QUE INTRODUZCA EL ID DE ORGAN QUE COINCIDE
			// CON EL DE DONOR Y HACER INSERT PARA QUE LO GUARDE EN LA TABLA
			// Get the employee info from the command prompt
			System.out.println("Please, input the patient info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Patient name: ");
			String patientname = reader.readLine();
			System.out.print("Gender: ");
			String patientgender = reader.readLine();
			System.out.print("Age: ");
			aux = reader.readLine();
			Integer patientage=Integer.parseInt(aux);
			System.out.print("Medical History: ");
			aux = reader.readLine();
			Integer medical_history=Integer.parseInt(aux);
			System.out.print("Hospital id: ");
			String hospital_id= reader.readLine();
			
			

			Statement stmt = c.createStatement();
			//String sql = "INSERT INTO patient (name, gender, age, MH_ID, H_ID) " + "VALUES (?, ?, ?, ?, ?)";
			//PreparedStatement prep = c.prepareSatement(sql);
			//prep.setString(1, patientname);
			//prep.setNull(3, java.sql.TYPES.INTEGER);
			String sql = "INSERT INTO patient (name, gender, age, MH_ID, H_ID) " + "VALUES ('" + patientname + "', '"
					+ patientgender + "', '" + patientage + "," + medical_history + "," + hospital_id + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Patient info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDonor() {
		try {

			// TODO TENDREMOS QUE HACER UN METODO QUE INTRODUZCA EL ID DE ORGAN QUE COINCIDE
			// CON EL DE DONOR Y HACER INSERT PARA QUE LO GUARDE EN LA TABLA
			// Get the employee info from the command prompt
			System.out.println("Please, input the donor info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Donor name: ");
			String donorname = reader.readLine();
			System.out.print("Gender: ");
			String donorgender = reader.readLine();
			System.out.print("Age: ");
			String donorage = reader.readLine();
			System.out.print("Medical History: ");
			String medical_history = reader.readLine();

			Statement stmt = c.createStatement();
			String sql = "INSERT INTO donor (name, gender, age, MH_ID) " + "VALUES ('" + donorname + "', '"
					+ donorgender + "', '" + donorage + "," + medical_history + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Donor info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addHospital() {
		try {

			// TODO TENDREMOS QUE HACER UN METODO QUE INTRODUZCA EL ID DE ORGAN QUE COINCIDE
			// CON EL DE DONOR Y HACER INSERT PARA QUE LO GUARDE EN LA TABLA
			// Get the employee info from the command prompt
			System.out.println("Please, input the hospital info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("id name: ");
			String idname = reader.readLine();
			System.out.print("city: ");
			String city = reader.readLine();

			Statement stmt = c.createStatement();
			String sql = "INSERT INTO hospital (id, city) " + "VALUES ('" + idname + "', '" + city + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("hospital info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDonation() {
		try {

			System.out.println("Please, input the donation info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("type: ");
			String type = reader.readLine();
			System.out.print("name: ");
			String name = reader.readLine();

			Statement stmt = c.createStatement();
			String sql = "INSERT INTO donation (type,name) " + "VALUES ('" + type + "', '" + name + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Donation info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addMedicalHospital() {
		try {

			System.out.println("Please, input the MedicalHistory info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Id: ");
			String id = reader.readLine();
			System.out.print("Blood type: ");
			String bloodtype = reader.readLine();
			System.out.print("Previous illnesses: ");
			String previous_illnesses = reader.readLine();
			System.out.print("Actual illnesses: ");
			String actual_illnesses = reader.readLine();
			System.out.print("Date: ");
			String date = reader.readLine();

			Statement stmt = c.createStatement();
			String sql = "INSERT INTO MH (id, blootype,p_illnesses,a_illnesses,date) " + "VALUES ('" + id + "', '"
					+ bloodtype + "', '" + previous_illnesses + "', '" + actual_illnesses + "', '" + date + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Medical history info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//@Override
	public Patient getPatient(int id) {
		try {
			String sql = "SELECT * FROM patient WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			if (rs.next()) {
				String patientName = rs.getString("name");
				return new Patient(id, patientName);
			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

//@Override
	public List<Patient> searchPatientByName(String name) {
		List<Patient> patients = new ArrayList<Patient>();
		try {
			String sql = "SELECT * FROM patient WHERE name LIKE ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int id = rs.getInt("id");
				String patientName = rs.getString("name");
				Patient patient = new Patient(id, patientName);
				patients.add(patient);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

			
public List<Donor> searchDonorById(int id) {
	List<Donor> donorList = new ArrayList<Donor>();
	try {
		String sql = "SELECT * FROM Donor WHERE id = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) { // true: there is another result and I have advanced to it
							// false: there are no more results
			String name=rs.getString("name");
			String gender=rs.getString("gender");
			int age=rs.getInt("age");
			int organ_ID=rs.getInt("organ_ID");
			int MH_ID=rs.getInt("MH_ID");
			String h_id=rs.getString("h_id");
			int idDonor=rs.getInt("id");
			Donor donor1= new Donor(name,gender,age,organ_ID,MH_ID,h_id,idDonor);
			donorList.add(donor1);
		}
		rs.close();
		stmt.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return donorList;
}


	@Override
	public void disconnect() {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("There was a problem while closing the database connection.");
			e.printStackTrace();
		}

	}

}
