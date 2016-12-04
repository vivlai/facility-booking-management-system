<%@page import="model.Location"%>
<%@page import="dao.LocationDao"%>
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
       <a class="navbar-brand" href="admin.jsp">FBMS</a>
     </div>
  
     <!-- Collect the nav links, forms, and other content for toggling -->
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav">
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Actions <span class="caret"></span></a>
           <ul class="dropdown-menu">
				<li><a href="admin-make-booking.jsp">Make Booking</a></li>
				<li><a href="admin-add-location.jsp">Add Location</a></li>
				<li><a href="admin-view-location.jsp">View Location</a></li>
				<li><a href="admin-delete-account.jsp">Delete Student Account</a></li>
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
      <h2>Delete Location</h2><br>
		<form action="DeleteLocationController" method="post">
        <% String errorMessage = request.getParameter("error"); %>
        <% if (errorMessage != null) { %>
        	<label><%=errorMessage%></label> <br><br>
        <% } %> 
        <% String locationIdString = request.getParameter("id");
           int locationId = Integer.parseInt(locationIdString);
           Location location = LocationDao.getInstance().getLocation(locationId);	
        %>
        			<table class="table table-hover">
				<thead>
					<tr>
						<th>Location ID</th>
						<th>Location Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=location.getId()%></td>
						<td><a href="location-schedule.jsp?id=<%=location.getId()%>"><%=location.getLocationName()%></a></td>
					</tr>
				</tbody>
			</table>

        <br><br>
			<p>Are you sure you want to delete this location?</p>
			<form action="DeleteBookingController" method="post">
				<div class="radio">
					<label> 
					  <input type="radio" name="optionsRadios" id="optionsRadios1" value=<%=locationId %> /> Yes, I want to delete this location.
					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="optionsRadios"
						id="optionsRadios2" value="no" checked> No, I change my
						mind.
					</label>
				</div>
				<button type="submit" class="btn btn-info">Submit</button>
			</form>
    </form>
    </div>
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.selecter.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.stepper.min.js"></script>
</body>
</html>