package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.Person;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() {
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
	
	private Person model;
	
	public PersonController(Person model) {
		this.model = model;
	}
	
	public String getEmail() {
		return model.getEmail();
	}
	
	public void setEmail(String email) {
		model.setEmail(email);;
	}
	
	public String getPassword() {
		return model.getPassword();
	}
	
	public void setPassword(String password) {
		model.setPassword(password);;
	}
	
	public String getRole() {
		return model.getRole();
	}
	
	public void setRole(String role) {
		model.setRole(role);;
	}
	
	public ArrayList<Booking> getBookings() {
		return model.getBookings();
	}
	
	public void setBookings(ArrayList<Booking> bookings) {
		model.setBookings(bookings);;
	}

}
