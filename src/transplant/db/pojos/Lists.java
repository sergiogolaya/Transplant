package transplant.db.pojos;

import java.util.ArrayList;
import java.util.List;

public class Lists {
	private List<Patient> patientlist;
	
	public Lists(List<Patient> patientlist) {
		super();
		this.patientlist = new ArrayList<Patient>();
	}

	public void addPatient(Patient p) {
		if(!patientlist.contains(p)) {
			patientlist.add(p);
		}
	}
}
