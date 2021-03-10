package transplant.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import transplant.db.ifaces.DBManager;

public class JDBCManager implements DBManager {
    
	private Connection c;
	
	@Override
	public void connect() {
		try {
	        // Open database connection
		    Class.forName("org.sqlite.JDBC");
		    Connection c = DriverManager.getConnection("jdbc:sqlite:./db/transplant.db");
	        c.createStatement().execute("PRAGMA foreign_keys=ON");
		    System.out.println("Database connection opened.");
            this.createTables();
	}   
		catch(SQLException sqlE) {
			 System.out.println("There was a database exception.");
		     sqlE.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("There was a general exception.");
			e.printStackTrace();
		}
	}
	
	private void createTables() {
		// If the tables are not created already, create them
	    
		Statement stm1;
		try {
            //Create the jobs table
			stm1=c.createStatement();
		
		    String sql1="(CREATE TABLE patient"
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "name TEXT NOT NULL,"
				      + "gender ENUM('MUJER', 'HOMBRE') NOT NULL,"
				      + "age INTEGER NOT NULL,"
				      + "organ_ID INTEGER NOT NULL,"
				      + "MH_ID INTEGER NOT NULL,"
				      + "H_ID INTEGER NOT NULL)";
		   stm1.executeUpdate(sql1);
		   
			
		    String sql1="(CREATE TABLE donor"
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "name TEXT NOT NULL,"
				      + "gender ENUM('MUJER','HOMBRE'),"
				      + "age INTEGER NOT NULL,"
				      + "organ_ID INTEGER NOT NULL,"
				      + "MH_ID INTEGER NOT NULL)";
				
		   stm1.executeUpdate(sql1);
		   
		   
			
		    String sql1="(CREATE TABLE hospital"
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "city TEXT NOT NULL)";
				      
		   stm1.executeUpdate(sql1);
		   
		   
			
		    String sql1="(CREATE TABLE organ"
				      + "type ENUM('AUTOTRANSPLANTE', 'ISOTRANSPLANTE', 'XENOTRANSPLANTE', 'ALOTRANSPLANTE',"
				      + "name TEXT NOT NULL)";
				      
		   stm1.executeUpdate(sql1);
		   
		   
			
		    String sql1="(CREATE TABLE MH"
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				      + "blood_type ENUM('0-', '0+', 'A-', 'A+', 'B-', 'B+', 'AB-', 'AB+')", 
				      + "age INTEGER NOT NULL,"
				      + "organ_ID INTEGER NOT NULL,"
				      + "MH_ID INTEGER NOT NULL,"
				      + "H_ID INTEGER NOT NULL)";
		   
		    stm1.executeUpdate(sql1);
		    
			
		    String sql1="(CREATE TABLE request"
				      + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
		    		  + "match BOOLEAN)";
				      
		   stm1.executeUpdate(sql1);
		   
		   String sql1="(CREATE TABLE relationship"
				      + "patient_id INTEGER,"
		    		  + "donor_id INTEGER,"
				      + "PRIMARY KEY(patient_id, donor_id)";
				      
		   stm1.executeUpdate(sql1);
		   
		   
		   
		  
		} catch(SQLE Exception e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

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
