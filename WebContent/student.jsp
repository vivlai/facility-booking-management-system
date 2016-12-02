<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Booking"%>
<%@page import="model.Location"%>
<%@page import="model.Person"%>
<%@page import="dao.PersonDao"%>
<%@page import="dao.BookingDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/css/bootflat.min.css">
  <title>Facility Booking Management System</title>
</head>

<body>
  <nav class="navbar navbar-default navbar-inverse">
   <div class="container-fluid">
     <!-- Brand and toggle get grouped for better mobile display -->
     <div class="navbar-header navbar-inverse">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#">FBMS</a>
     </div>
  
     <!-- Collect the nav links, forms, and other content for toggling -->
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav">
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Actions <span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="student-make-booking.jsp">Make Booking</a></li>
             <li><a href="student-view-location.jsp">View Locations Schedule</a></li>
           </ul>
         </li>
       </ul>
       
       <ul class="nav navbar-nav navbar-right">
         <li><a href="#">Log out</a></li>
       </ul>
       
     </div><!-- /.navbar-collapse -->
   </div><!-- /.container-fluid -->
  </nav>
  
  <div class="container">
    <div class="span12">
      <h2>My Bookings</h2><br>
      <% 
      if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("login.jsp?error=Invalid credentials");
		return;
      } 
  	  
      Person person = (Person) request.getSession().getAttribute("user");
      int personId = person.getId();
      ArrayList<Booking> bookings = BookingDao.getInstance().getBookingsByPerson(personId);
      
      %>
      
      <table class="table table-hover">
        <thead>
          <tr>
            <th>Booking ID</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Location</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <% for (Booking booking : bookings) { %>
          <% Location location = booking.getLocation(); %>
            <tr>
              <td><%=booking.getId() %></td>
              <td><%=booking.getStartDate() %></td>
              <td><%=booking.getEndDate() %></td>
              <td><%=location.getLocationName() %></td>
              <!-- <td><button class="btn btn-info" id="editBooking"<%=booking.getId() %>>Edit</button></td>  -->
              <td><a href="student-edit-booking.jsp?id=<%=booking.getId()%>" class="btn btn-info">Edit</a></td>
              <td><a href="student-delete-booking.jsp?id=<%=booking.getId()%>" class="btn btn-danger">Delete</button></td>
            </tr>
          <% } %>
        </tbody>
      </table>

    </div>
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.selecter.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.stepper.min.js"></script>
</body>
</html>