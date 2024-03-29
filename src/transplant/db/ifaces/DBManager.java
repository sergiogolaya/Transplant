package transplant.db.ifaces;

import java.util.List;

import transplant.db.pojos.Donation;
import transplant.db.pojos.Donor;
import transplant.db.pojos.Hospital;
import transplant.db.pojos.M_h;
import transplant.db.pojos.Patient;
import transplant.db.pojos.Request;

public interface DBManager {
	
	public void connect();
	public void disconnect();
	
	public void addPatient(Patient p);
	public void addDonor(Donor d);
	public void addHospital(Hospital h);
	public void addDonation(Donation don);
	public void addMedicalHistory(M_h mh);
	public void addRequest(Request r);
	public List<Patient> searchPatientById(Integer id);
	public List<Donor> searchDonorById(Integer id);
	public void printRequests();
	public void modifyPatient(Integer id, Integer newAge);
	public void modifyDonor(Integer id, Integer newAge);
	public void deleteRequest(Integer patient_id, Integer donor_id);
	public List<Patient> getAllPatXml();
	public List<Donor> getAllDonXml();

	
	
	
	

}
