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

import transplant.db.ifaces.DBManager;
import transplant.db.jdbc.JDBCManager;
import transplant.db.pojos.DonList;
import transplant.db.pojos.Donor;
import transplant.db.pojos.PatList;
import transplant.db.pojos.Patient;

public class Java2XmlReport {

	private static DBManager inter = new JDBCManager();

	public void getXMLPat() {
		try {
			inter.connect();
			JAXBContext jaxbContextPatList = JAXBContext.newInstance(PatList.class);
			Marshaller pat_marshaller = jaxbContextPatList.createMarshaller();
			pat_marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xml_html/allPat.xml");
			file.createNewFile();
			PatList patos = new PatList(inter.getAllPatXml());
			pat_marshaller.marshal(patos, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getXMLDon() {
		try {
			inter.connect();
			JAXBContext jaxbContextDonList = JAXBContext.newInstance(DonList.class);
			Marshaller don_marshaller = jaxbContextDonList.createMarshaller();
			don_marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xml_html/allDon.xml");
			file.createNewFile();
			DonList donos = new DonList(inter.getAllDonXml());
			don_marshaller.marshal(donos, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}