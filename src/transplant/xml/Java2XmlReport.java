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

public class Java2XmlReport {

	
	private static EntityManager em;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	private static void printReports() {
		Query q1 = em.createNativeQuery("SELECT * FROM donor", Donor.class);
		List<Donor> reps = (List<Donor>) q1.getResultList();
		
		for (Donor rep : reps) {
			System.out.println(rep);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		em = Persistence.createEntityManagerFactory("user-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
				
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Donor.class);
		// Get the marshaller
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		// Pretty formatting
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		
		// Choose the report to turn into an XML
		// Choose his new department
		printReports();
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

	}
}