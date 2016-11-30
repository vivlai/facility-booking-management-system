package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDao;
import dao.LocationDao;
import dao.PersonDao;
import model.Booking;
import model.Location;
import model.Person;
import util.DateUtil;

@WebServlet("/EditBookingController")
public class EditBookingController extends HttpServlet {
	
	/*
	 * <form action="AddBookingController" method="post">
	 *     Start Date: <input type="date" name="startDate"/> <br/>
	 *     End Date: <input type="date" name="endDate"/> <br/>
	 *     Location: <select name="location">
	 *         <% for (Location location : LocationDao.getInstance().getAllLocations()) { %>
	 *             <option value="<%=location.getId()%>"><%=location.getName()%></option> 
	 *         <% } %>
	 *     </select> <br/>
	 *     Additional Persons (comma separated email list): <input type="text" name="persons"/>
	 *     <input type="submit" value="submit"/>
	 * </form>
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person loggedInUser = (Person) request.getSession().getAttribute("user");
		if (loggedInUser == null) {
			response.sendRedirect("login.jsp?error=You are not logged in");
			return;
		}
		
		String stringId = request.getParameter("bookingId");
		int bookingId = Integer.parseInt(stringId);
		Timestamp startDate = DateUtil.convertStringToTimestamp( request.getParameter("startDate") );
		Timestamp endDate = DateUtil.convertStringToTimestamp( request.getParameter("endDate") );
		Location location = LocationDao.getInstance().getLocation(Integer.parseInt(request.getParameter("location")));
		ArrayList<Person> persons = new ArrayList<Person>();
		String[] personEmails = request.getParameter("persons").split(",");
		for (String email : personEmails) {
			Person person = PersonDao.getInstance().getPerson(email);
			// to-do: check if person exists
			if (person == null) {
				response.sendRedirect("create.jsp?error=The email " + email + " does not exist.");
				return;
			} 
			
			persons.add(PersonDao.getInstance().getPerson(email));
		}
		persons.add(loggedInUser);
		
		Booking booking = BookingDao.getInstance().getBooking(bookingId);
		booking.setStartDate(startDate);
		booking.setEndDate(endDate);
		booking.setLocation(location);
		booking.setPersons(persons);
		BookingDao.getInstance().updateBooking(booking);
		
		//response.sendRedirect("student.jsp");
		response.sendRedirect("student-view-booking.jsp?id=" + booking.getId()+
				"&startDate=" + startDate + 
				"&endDate=" + endDate + 
				"&location=" + location.getLocationName());
		
	}
}
