package transplant.db.pojos;

public class M_h {
	public class organ {
		private Integer id;
		private String previous_I;
		private String actual_I;
		
		
		public organ(Integer id, String previous_I, String actual_I) {
			super();
			this.id = id;
			this.previous_I = previous_I;
			this.actual_I = actual_I;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
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


		@Override
		public String toString() {
			return "organ [id=" + id + ", previous_I=" + previous_I + ", actual_I=" + actual_I + "]";
		}

	
}


}
