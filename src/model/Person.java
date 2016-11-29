package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
	
	private int id;
	private String email;
	private String password;
	private String role;
	private ArrayList<Booking> bookings;
	
	public Person(int id, String email, String password, String role, ArrayList<Booking> bookings) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.bookings = bookings;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
}
