
public class Resources {
	
	private String resourceId;
	private String name;
	private boolean booked;
	
	public Resources(String resourceId, String name) {
		super();
		this.resourceId = resourceId;
		this.name = name;
		}
	
	public String getResourceId() {
		return resourceId;
	}
	public String getName() {
		return name;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	public String toString() {
		return "Resource Id:" + resourceId + ", Name:" + name + ", Booked:" + booked;
	}
	
	
}
