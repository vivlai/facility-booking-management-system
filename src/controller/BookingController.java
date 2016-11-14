package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.Location;
import model.Person;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Booking model;
	
	public BookingController(Booking model) {
		this.model = model;
	}
	
	public Date getStartDate() {
		return model.getStartDate();
	}
	
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}
	
	public Date getEndDate() {
		return model.getEndDate();
	}
	
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}
	
	public ArrayList<Person> getPersons() {
		return model.getPersons();
	}
	
	public void setPersons(ArrayList<Person> persons) {
		model.setPersons(persons);
	}
	
	public Location getLocation() {
		return model.getLocation();
	}
	
	public void setLocation(Location location) {
		model.setLocation(location);
	}

}
