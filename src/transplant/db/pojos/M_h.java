package transplant.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import transplant.xml.utils.SQLDateAdapter;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="MH")
@XmlType(propOrder= {"id", "bloodtype", "previous_I", "actual_I", "date"})
public class M_h implements Serializable{
	
	private static final long serialVersionUID = 7968504404923845972L;
		
	
	    @XmlElement
		private Integer id;
	    @XmlElement
		private String bloodtype;
	    @XmlElement
		private String previous_I;
	    @XmlElement
		private String actual_I;
	    @XmlElement
	    @XmlJavaTypeAdapter(SQLDateAdapter.class) 
		private Date date;
	    //@XmlElement(name = "MH")
		
		public M_h(Integer id, String bloodtype, String previous_I, String actual_I, Date date) {
			super();
			this.id = id;
			this.bloodtype=bloodtype;
			this.previous_I = previous_I;
			this.actual_I = actual_I;
			this.date = date;
		}
		


		public M_h(String bloodtype, String previous_I, String actual_I, Date date) {
			super();
			this.bloodtype=bloodtype;
			this.previous_I = previous_I;
			this.actual_I = actual_I;
			this.date = date;
		}



		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getBloodtype() {
			return bloodtype;
		}



		public void setBloodtype(String bloodtype) {
			this.bloodtype = bloodtype;
		}



		public String getPrevious_I() {
			return previous_I;
		}


		public void setPrevious_I(String previous_I) {
			this.previous_I = previous_I;
		}


		public String getActual_I() {
			return actual_I;
		}


		public void setActual_I(String actual_I) {
			this.actual_I = actual_I;
		}



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		

		@Override
		public String toString() {
			return "M_h [id=" + id + ", bloodtype=" + bloodtype + ", previous_I=" + previous_I + ", actual_I="
					+ actual_I + ", date=" + date + "]";
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			M_h other = (M_h) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}


	
}