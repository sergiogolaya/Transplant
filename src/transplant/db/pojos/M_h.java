package transplant.db.pojos;

import java.sql.Date;

public class M_h {
	
		private Integer id;
		private String bloodtype;
		private String previous_I;
		private String actual_I;
		private Date date;
		
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



