
package sample.db.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLInsert {


public static void main(String args[]) {
		try {
			// Open database connection
			Class.forpatient("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/company.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");

			// Get the employee info from the command prompt
			System.out.println("Please, input the request info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Patient: ");
			String patient = reader.readLine();
			System.out.print("Donor: ");
			String address = reader.readLine();

			// Insert new record: begin
			Statement stmt = c.createStatement();
			String sql = "INSERT INTO request (patient, donor) "
					+ "VALUES ('" + patient + "', '" + donor + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Request info processed");
			System.out.println("Records inserted.");
			
			
			String sql = "INSERT INTO patient (name, gender, age) "
					+ "VALUES ('" + name + "', '" + gender + "', '" + age + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Patient info processed");
			System.out.println("Records inserted.");
			
			String sql = "INSERT INTO donor (name, gender, age) "
					+ "VALUES ('" + name + "', '" + gender + "', '" + age + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Donor info processed");
			System.out.println("Records inserted.");
			
			String sql = "INSERT INTO hospital (city, id) "
					+ "VALUES ('" + city + "', '" + id + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Hospital info processed");
			System.out.println("Records inserted.");
			
			String sql = "INSERT INTO organ (id, name, type) "
					+ "VALUES ('" + id + "', '" + name + "' "+ type + ");";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Organ info processed");
			System.out.println("Records inserted.");
			
			String sql = "INSERT INTO mh (id, previous illnesses, actual illnesses, blood type) "
					+ "VALUES ('" + id + "', '" + previous illnesses + "', '"+ actual illnesses +"' ,'"+ blood type +"');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("MH info processed");
			System.out.println("Records inserted.");
			
			
			
			
			// Insert new record: end

			// Close database connection
			c.close();
			System.out.println("Database connection closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}