package transplant.xml;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import transplant.db.pojos.Donor;
import transplant.db.pojos.Patient;

public class Java2XmlReport {

	
	private static EntityManager em;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	private static void printReportsDonor() {
		Query q1 = em.createNativeQuery("SELECT * FROM donor", Donor.class);
		List<Donor> reps = (List<Donor>) q1.getResultList();
		
		for (Donor rep : reps) {
			System.out.println(rep);
		}
	}
	
	private static void printReportsPatient() {
		Query q1 = em.createNativeQuery("SELECT * FROM patient", Patient.class);
		List<Patient> reps = (List<Patient>) q1.getResultList();
		
		for (Patient rep : reps) {
			System.out.println(rep);
		}
	} 
	
	public static void main(String[] args) throws Exception {
		
		em = Persistence.createEntityManagerFactory("user-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
			

		//DONOR
		JAXBContext jaxbContext = JAXBContext.newInstance(Donor.class);
		// Get the marshaller
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		// Pretty formatting
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		
		// Choose the report to turn into an XML
		// Choose his new department
		printReportsDonor();
		System.out.print("Choose a DONOR to turn into an XML file:");
		int rep_id = Integer.parseInt(reader.readLine());
		Query q2 = em.createNativeQuery("SELECT * FROM donor WHERE id = ?", Donor.class);
		q2.setParameter(1, rep_id);
		Donor donor1 = (Donor) q2.getSingleResult();
		
		// Use the Marshaller to marshal the Java object to a file
		File file = new File("./xmls/Sample-Report.xml");
		marshaller.marshal(donor1, file);
		// Printout
		marshaller.marshal(donor1, System.out);
		 
		
		//PATIENT
		jaxbContext = JAXBContext.newInstance(Patient.class);
		// Get the marshaller
		marshaller = jaxbContext.createMarshaller();
		
		// Pretty formatting
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		
		// Choose the report to turn into an XML
		// Choose his new department
		printReportsPatient();
		System.out.print("Choose a PATIENT to turn into an XML file:");
		rep_id = Integer.parseInt(reader.readLine());
		q2 = em.createNativeQuery("SELECT * FROM patient WHERE id = ?", Patient.class);
		q2.setParameter(1, rep_id);
		Patient patient1 = (Patient) q2.getSingleResult();
		
		// Use the Marshaller to marshal the Java object to a file
		file = new File("./xmls/Sample-Report.xml");
		marshaller.marshal(patient1, file);
		// Printout
		marshaller.marshal(patient1, System.out);

	}
}