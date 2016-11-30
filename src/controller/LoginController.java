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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Person person = PersonDao.getInstance().getPerson(email);
		
		// error checking
		try {
			System.out.println(person.getPassword());
		} catch (NullPointerException e) {
			System.out.println("nullpointer exception");
			response.sendRedirect("login.jsp?error=Invalid credentials");
		    return;
		}
		
		if (!person.getPassword().equals(password)) {
		    response.sendRedirect("login.jsp?error=Invalid credentials");
		    return;
		}
		
		request.getSession().setAttribute("user", person);
		
		// if student, redirect to student
		// else redirect to admin
		System.out.println(person.getRole());
		if ( person.getRole().equals("student") ) {
			response.sendRedirect("student.jsp");
			return;
		} else {
			response.sendRedirect("admin.jsp");
			return;
		}
		
	}
}
