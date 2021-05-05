package transplant.ui;

<<<<<<< HEAD
import transplant.db.ifaces.DBManager;

import transplant.db.jdbc.JDBCManager;
=======
import java.util.List;
>>>>>>> branch 'master' of https://github.com/sergiogolaya/Transplant.git

/*import java.util.ArrayList;
import java.util.List;

import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;*/
import transplant.db.pojos.Patient;


public class Menu {
<<<<<<< HEAD

	public static DBManager dbman = new JDBCManager();
=======
>>>>>>> branch 'master' of https://github.com/sergiogolaya/Transplant.git
	public static void main(String[] args) {
<<<<<<< HEAD
		
		dbman.connect();
		//dbman.addPatient();
		dbman.disconnect();
		
		

=======
		List<Patient> list = new List();
		Patient patient = new Patient(1, "Sergio", "male", 21, 1, 2, 3);
		patient.addPatient(patient);
		System.out.println(patient);
>>>>>>> branch 'master' of https://github.com/sergiogolaya/Transplant.git
	}

}
