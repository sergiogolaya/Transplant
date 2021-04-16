package transplant.db.ifaces;

public interface DBManager {
	
	public void connect();
	public void disconnect();
	
	public void addPatient(Patient p);
	public void addDonor(Donor d);
	public Patient getPatient(int id);
	//public List<Person> searchPersonByName(String name);
	
	
	

}
