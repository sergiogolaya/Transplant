package transplant.ui;

import transplant.db.ifaces.DBManager;

import transplant.db.jdbc.JDBCManager;



public class Menu {

	public static DBManager dbman = new JDBCManager();
	public static void main(String[] args) {
		
		dbman.connect();
		//dbman.addPatient();
		dbman.disconnect();
		
		

	}

}
