<%@page import="model.Location"%>
<%@page import="dao.LocationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker-standalone.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.css">
  <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/css/bootflat.min.css"> -->
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
       <a class="navbar-brand" href="student.jsp">FBMS</a>
     </div>
  
     <!-- Collect the nav links, forms, and other content for toggling -->
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav">
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Actions <span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="student-make-booking.jsp">Make Booking</a></li>
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
      <h2>Booking Confirmation</h2><br>
        <% 
        String stringId = request.getParameter("id"); 
    	int bookingId = 0;
    	if (stringId != null){
    		bookingId = Integer.parseInt(stringId);
    	}
        String startDate = request.getParameter("startDate"); 
        String endDate = request.getParameter("endDate"); 
        String location = request.getParameter("location"); 
        if (stringId == null) 
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
          <tr>
            <td><%=bookingId %></td>
            <td><%=startDate %></td>
            <td><%=endDate %></td>
            <td><%=location %></td>
            <td><a href="student-edit-booking.jsp?id="<%=bookingId %> class="btn btn-info">Edit</button></td>
            <td><button class="btn btn-danger" id="deleteBooking"<%=bookingId %>>Delete</button></td>
          </tr>
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