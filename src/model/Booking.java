package model;

import java.util.ArrayList;
import java.sql.Date;

public class Booking {
	private int id;
	private Date startDate;
	private Date endDate;
	private ArrayList<Person> persons;
	private Location location;
	
	public Booking(int id, Date startDate, Date endDate, ArrayList<Person> persons, Location location) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.persons = persons;
		this.location = location;
	}

	public int getId() {
		return id;
	}
	
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
