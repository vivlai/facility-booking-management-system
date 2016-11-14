package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Booking;
import model.Location;

public class BookingDao {
	ArrayList<Booking> bookings;
	
	public BookingDao(){
		/*students = new ArrayList<Student>();
		Student student1 = new Student("Robert",0);
		Student student2 = new Student("John",1);
		students.add(student1);
		students.add(student2);*/		
	}
	
	public void deleteBooking(Date startDate, Location location) {
		for (Booking b : bookings) {
			if (b.getStartDate() == startDate && b.getLocation() == location) {
				bookings.remove(b);
			}
		}
	}
	
	public ArrayList<Booking> getAllBookings() {
		return bookings;
	}
	
	public Booking getBooking(Date startDate, Location location) {
		for (Booking b : bookings) {
			if (b.getStartDate() == startDate && b.getLocation() == location) {
				return b;
			}
		}
		return null;
	}
	
	public void updateBooking(Date startDate, Location location, Date newStartDate, Date newEndDate, Location newLocation) {
		for (Booking b : bookings) {
			if (b.getStartDate() == startDate && b.getLocation() == location) {
				b.setStartDate(newStartDate);
				b.setEndDate(newEndDate);
				b.setLocation(newLocation);
			}
		}
	}
}
