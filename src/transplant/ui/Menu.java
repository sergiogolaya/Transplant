package transplant.ui;

import java.util.List;

/*import java.util.ArrayList;
import java.util.List;

import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;*/
import transplant.db.pojos.Patient;

public class Menu {
	public static void main(String[] args) {
		List<Patient> list = new List();
		Patient patient = new Patient(1, "Sergio", "male", 21, 1, 2, 3);
		patient.addPatient(patient);
		System.out.println(patient);
	}

}
