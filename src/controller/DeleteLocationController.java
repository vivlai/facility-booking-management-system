package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
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

@WebServlet("/DeleteLocationController")
public class DeleteLocationController extends HttpServlet {
	
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
		
		if (!loggedInUser.getRole().equals("admin") ) {
			response.sendRedirect("student.jsp?error=You are not admin");
			return;
		}
		
		String state = (String) request.getParameter("optionsRadios");
		System.out.println(state);
		if (!state.equals("no")) {
			int id = Integer.parseInt(state);
			System.out.println("id="+id);
			Location location = (Location) LocationDao.getInstance().getLocation(id);
			LocationDao.getInstance().deleteLocation(location);
			response.sendRedirect("admin-view-location.jsp?message=The location " + location.getLocationName() + " deleted.");
			return;
		}
		response.sendRedirect("admin-view-location.jsp");
	}
}
