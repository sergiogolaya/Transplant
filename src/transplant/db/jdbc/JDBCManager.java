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
import transplant.db.pojos.Donation;
import transplant.db.pojos.Donor;
import transplant.db.pojos.Hospital;
import transplant.db.pojos.M_h;
import transplant.db.pojos.Patient;
import transplant.db.pojos.Request;

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

			Statement stm1 = c.createStatement();

			String sql1 = "CREATE TABLE patient( " + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT NOT NULL,"
					+ "gender TEXT NOT NULL," + "age INTEGER NOT NULL," + "organ_ID INTEGER NOT NULL,"
					+ "MH_ID INTEGER NOT NULL," + "H_ID INTEGER NOT NULL)";
			stm1.executeUpdate(sql1);

			sql1 = "CREATE TABLE donor( " + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT NOT NULL,"
					+ "gender TEXT NOT NULL," + "age INTEGER NOT NULL," + "organ_ID INTEGER NOT NULL,"
					+ "MH_ID INTEGER NOT NULL)";
			stm1.executeUpdate(sql1);

			sql1 = "CREATE TABLE hospital( " + "id TEXT PRIMARY KEY ," + "city TEXT NOT NULL)";

			stm1.executeUpdate(sql1);
			sql1 = "CREATE TABLE donation( " + "type TEXT NOT NULL," + "name TEXT NOT NULL)";

			stm1.executeUpdate(sql1);

			sql1 = "CREATE TABLE MH (" + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "blood_type TEXT,"
					+ "p_illnesses TEXT," + "a_illnesses TEXT," + "date DATE)";

			stm1.executeUpdate(sql1);

			sql1 = "CREATE TABLE request(" + "patient_id INTEGER," + "donor_id INTEGER,"
					+ "PRIMARY KEY(patient_id, donor_id))";

			stm1.executeUpdate(sql1);
			stm1.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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

	public void addPatient(Patient p) {
		try {

			// TODO TENDREMOS QUE HACER UN METODO QUE INTRODUZCA EL ID DE ORGAN QUE COINCIDE
			// CON EL DE DONOR Y HACER INSERT PARA QUE LO GUARDE EN LA TABLA
			// Get the employee info from the command prompt

			String sql = "INSERT INTO patient (name, gender, age, organ_ID, MH_ID, H_ID) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, p.getName());
			prep.setString(2, p.getGender());
			prep.setInt(3, p.getAge());
			prep.setInt(4, p.getDonation_id());
			prep.setInt(5, p.getMh_id());
			prep.setString(6, p.getH_id());
			prep.executeUpdate();
			prep.close();

			System.out.println("Patient info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDonor(Donor d) {
		try {

			String sql = "INSERT INTO donor (name, gender, age, organ_ID, MH_ID) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, d.getName());
			prep.setString(2, d.getGender());
			prep.setInt(3, d.getAge());
			prep.setInt(4, d.getDonation_id());
			prep.setInt(5, d.getMh_id());
			prep.executeUpdate();
			prep.close();

			System.out.println("Donor info processed");
			System.out.println("Records inserted.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addHospital(Hospital h) {
		try {
			String sql = "INSERT INTO hospital (id,city) VALUES (?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, h.getIdname());
			prep.setString(2, h.getCity());
			prep.executeUpdate();
			prep.close();

			System.out.println("Hospital information processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDonation(Donation don) {
		try {
			String sql = "INSERT INTO donation (type,name) VALUES (?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, don.getType());
			prep.setString(2, don.getName());
			prep.executeUpdate();
			prep.close();
			System.out.println("Donation info processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMedicalHistory(M_h mh) {
		try {
			String sql = "INSERT INTO MH (blood_type, p_illnesses, a_illnesses, date) VALUES (?, ?, ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, mh.getBloodtype());
			prep.setString(2, mh.getPrevious_I());
			prep.setString(3, mh.getActual_I());
			prep.setDate(4, mh.getDate());
			prep.executeUpdate();
			prep.close();
			System.out.println("Medical history information processed");
			System.out.println("Records inserted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRequest(Request r) {
		try {
			String sql = "INSERT INTO request (patient_id,donor_id) VALUES (?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, r.getPatient_id());
			prep.setInt(2, r.getDonor_id());
			prep.executeUpdate();
			prep.close();

			System.out.println("Request information processed");
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

				return new Patient(id, rs.getString("name"), rs.getString("gender"), rs.getInt("age"),
						rs.getInt("donation_id"), rs.getInt("mh_id"), rs.getString("h_id"));

			}
			rs.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void printRequests() {
		try {

			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM request";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int p_id = rs.getInt("patient_id");
				int d_id = rs.getInt("donor_id");
				Request request = new Request(p_id, d_id);
				System.out.println(request);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modifyPatient(Integer id, Integer newAge) {
		try {

			String sql = "UPDATE patient SET age=? WHERE id=?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, newAge);
			prep.setInt(2, id);
			prep.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteRequest(int patient_id, int donor_id) {
		
		try {
			String sql = "DELETE FROM request WHERE patient_id = ? AND donor_id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient_id);
			prep.setInt(2, donor_id);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Patient> searchPatientById(Integer id) {
		List<Patient> patients = new ArrayList<Patient>();
		try {

			String sql = "SELECT * FROM patient WHERE id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				int donation_id = rs.getInt("organ_ID");
				int mh_id = rs.getInt("MH_ID");
				String h_id = rs.getString("H_ID");
				Patient p = new Patient(id, name, gender, age, donation_id, mh_id, h_id);
				patients.add(p);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	public List<Donor> searchDonorById(Integer id) {
		List<Donor> donors = new ArrayList<Donor>();
		try {

			String sql = "SELECT * FROM donor WHERE id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				int donation_id = rs.getInt("organ_ID");
				int mh_id = rs.getInt("MH_ID");
				Donor d = new Donor(name, gender, age, donation_id, mh_id, id);
				donors.add(d);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return donors;
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

	@Override
	public void deleteRequest(Integer patient_id, Integer donor_id) {
		// TODO Auto-generated method stub
		
	}

}
