package transplant.xml;


import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import transplant.db.pojos.Donor;
import transplant.db.pojos.Patient;

public class Xml2JavaReport {

	private static final String PERSISTENCE_PROVIDER = "company-provider";
	private static EntityManagerFactory factory;

	public static void main(String[] args) throws JAXBException {

		// Create the JAXBContext
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
		// Get the unmarshaller
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		// Use the Unmarshaller to unmarshal the XML document from a file
		File file = new File("./xmls/External-Report.xml");
		Donor d1 = (Donor) unmarshaller.unmarshal(file);

		// Print the report
		System.out.println("Donor:");
		System.out.println("Name: " + d1.getName());
		System.out.println("Gender: " + d1.getGender());
		System.out.println("Age: " + d1.getAge());
		System.out.println("Donation id: " + d1.getDonation_id());
		System.out.println("medical history id: " + d1.getMh_id());
		
		
		
		
		List<Patient> pats = d1.getPatientlist();
		for (Patient pat : pats) {
			System.out.println("Author: " + pat.getName());
		}

		// Store the report in the database
		// Create entity manager
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_PROVIDER);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();

		// Create a transaction
		EntityTransaction tx1 = em.getTransaction();

		// Start transaction
		tx1.begin();

		// Persist
		// We assume the authors are not already in the database
		// In a real world, we should check if they already exist
		// and update them instead of inserting as new
		for (Patient patient : pats) {
			em.persist(pats);
		}
		em.persist(d1);
		
		// End transaction
		tx1.commit();
	}
}
