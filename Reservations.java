
public class Reservations {

	private String reserveId;
	private String userId;
	private String resourceId;
	private String date;
	private int duration;
		
	public Reservations(String reserveId, String userId, String resourceId, String date, int duration) {
		super();
		this.reserveId = reserveId;
		this.userId = userId;
		this.resourceId = resourceId;
		this.date = date;
		this.duration = duration;
		}


	public String getReserveId() {
		return reserveId;
	}


	public String getUserId() {
		return userId;
	}


	public String getResourceId() {
		return resourceId;
	}


	public String getDate() {
		return date;
	}


	public int getDuration() {
		return duration;
	}

		
	public void setReserveId(String reserveId) {
		this.reserveId = reserveId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String toString() {
	return "Reservation Id:" + reserveId + ", User Id:" + userId + ", Resource Id:" + resourceId + ", Date:"
				+ date + ", Duration:" + duration;
	}
	
	
	
}
