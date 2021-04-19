package transplant.db.ifaces;

public interface DBManager {
	
	public void connect();
	public void disconnect();
	
	public void addPatient();
	public void addDonor();

	//public List<Person> searchPersonByName(String name);
	
	
	

}
