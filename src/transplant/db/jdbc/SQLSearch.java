package transplant.db.jdbc;

import java.sql.*;
import java.util.*;
import java.io.*;
import transplant.db.pojos.Donor;
import transplant.db.pojos.Hospital;
import transplant.db.pojos.Patient;

public class SQLSearch {
	
	public static void main(String[] args) {
					PreparedStatement prep = null;
					int option;
			ResultSet rs = null ;
		try {
			Connection c;
			// Open database connection
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/transplant.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			
			do {
			
			System.out.println("What are you searching for?");
			System.out.println("\n1.Searching for a patient");
			System.out.println("\n2.Searching for a donor");
			System.out.println("\n3.Searching for a hospital");
			System.out.println("\nIntroduce an option (1-3): ");
			String aux = reader.readLine();
			option=Integer.parseInt(aux);

			
			switch(option) {
			//Search for a patient
			case 1:
				// Retrieve data: begin
				System.out.println("Introduce the id of the patient: ");
				String aux1 = reader.readLine();
				int searchId=Integer.parseInt(aux1);
				String sql = "SELECT * FROM patient WHERE id LIKE ?";
				prep = c.prepareStatement(sql);
				prep.setInt(1, searchId);
				rs = prep.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String gender = rs.getString("gender");
					int age = rs.getInt("age");
					int donation_id = rs.getInt("donation_ID");
					int mh_id = rs.getInt("MH_ID");
					String h_id = rs.getString("H_ID");
					Patient patient = new Patient(id, name, gender, age, donation_id, mh_id, h_id); 
					System.out.println(patient);
					
				}
				
			
			case 2:
			//Search for a donor
				System.out.println("Introduce the id of the donor: ");
				aux = reader.readLine();
				searchId=Integer.parseInt(aux);
				sql = "SELECT * FROM donor WHERE id  LIKE ?";
				prep = c.prepareStatement(sql);
				prep.setInt(1, searchId);
				rs = prep.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String gender = rs.getString("gender");
					int age = rs.getInt("age");
					int organid = rs.getInt("organ_ID");
					int mh_id = rs.getInt("MH_ID");
					
					Donor donor1 = new Donor(name, gender, age, organid, mh_id, id ); 
					System.out.println(donor1);
			}
				
				
			case 3:
			//Search for a hospital
			    System.out.println("Introduce the id of the hospital: ");
			    String searchName = reader.readLine();
			    sql = "SELECT * FROM hospital WHERE id LIKE ?";
				prep = c.prepareStatement(sql);
				prep.setString(1, searchName);
			    rs = prep.executeQuery();
				while (rs.next()) {
					String id = rs.getString("id");
					String city = rs.getString("city");
					
					Hospital hospital1 = new Hospital(id,city);
					System.out.println(hospital1);
				
				}
			}
			}while((option!=1)&&(option!=2)&&(option!=3));
			
			rs.close();
			prep.close();
			System.out.println("Search finished.");
			// Retrieve data: end
		    
			// Close database connection
			c.close();
			System.out.println("Database connection closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

			
		