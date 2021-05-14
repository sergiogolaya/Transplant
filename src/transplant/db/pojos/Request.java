package transplant.db.pojos;

public class Request {
	private Integer patient_id;
	private Integer donor_id;

	public Request(Integer patient_id, Integer donor_id) {
		super();
		this.patient_id = patient_id;
		this.donor_id = donor_id;
	}

	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public Integer getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Integer donor_id) {
		this.donor_id = donor_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donor_id == null) ? 0 : donor_id.hashCode());
		result = prime * result + ((patient_id == null) ? 0 : patient_id.hashCode());
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
		Request other = (Request) obj;
		if (donor_id == null) {
			if (other.donor_id != null)
				return false;
		} else if (!donor_id.equals(other.donor_id))
			return false;
		if (patient_id == null) {
			if (other.patient_id != null)
				return false;
		} else if (!patient_id.equals(other.patient_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [patient_id=" + patient_id + ", donor_id=" + donor_id + "]";
	}

}
