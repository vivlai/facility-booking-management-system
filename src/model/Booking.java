package model;

import java.util.ArrayList;
import java.util.Date;

public class Booking {
	private Date startDate;
	private Date endDate;
	private ArrayList<Person> persons;
	private Location location;
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public ArrayList<Person> getPersons() {
		return persons;
	}
	
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
