package transplant.ui;

import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;


public class Menu {

	public static void main(String[] args) {
		DBManager dbman = new JDBCManager();
		dbman.connect();
		

	}

}
