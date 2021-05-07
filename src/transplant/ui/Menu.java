package transplant.ui;

import transplant.db.ifaces.DBManager;

import transplant.db.jdbc.JDBCManager;
import java.util.List;
import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;
import transplant.db.pojos.Patient;


public class Menu {
	public static DBManager dbman = new JDBCManager();
	public static void main(String[] args) {
		dbman.connect();
		dbman.addPatient();
		dbman.disconnect();
		}

}
