package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Booking {
	private int id;
	private Timestamp startDate;
	private Timestamp endDate;
	private ArrayList<Person> persons;
	private Location location;
	
	public Booking(int id, Timestamp startDate, Timestamp endDate, ArrayList<Person> persons, Location location) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.persons = persons;
		this.location = location;
	}

	public int getId() {
		return id;
	}
	
	public Timestamp getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	
	public Timestamp getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Timestamp endDate) {
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
