package model;

public class Location {
	private int id;
	private String locationName;
	
	public Location(int id, String locationName) {
		this.id = id;
		this.locationName = locationName;
	}

	public int getId() {
		return id;
	}

	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
