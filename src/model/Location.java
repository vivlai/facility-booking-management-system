package model;

import java.util.ArrayList;

public class Location {
	private String locationName;
	private ArrayList<Booking> bookings;
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
}
