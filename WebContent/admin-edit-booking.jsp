<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.Timestamp" %>
<%@page import="model.Person"%>
<%@page import="model.Booking"%>
<%@page import="model.Location"%>
<%@page import="dao.LocationDao"%>
<%@page import="dao.BookingDao"%>
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
       <a class="navbar-brand" href="#">FBMS</a>
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
      <h2>Edit Booking</h2><br>
        <% 
        String stringId = request.getParameter("id");
        int bookingId = Integer.parseInt(stringId);
        Booking booking = BookingDao.getInstance().getBooking(bookingId);
        Timestamp startDate = booking.getStartDate();
        Timestamp endDate = booking.getEndDate();
        
        ArrayList<Person> persons = booking.getPersons();
        String list = "";
        int count = 1;
        for (Person person : persons) {
          String email = person.getEmail();
          if (count == persons.size()) {
            
          } else {
            email = email + ", ";
          }
          list += email;
          count++;
        }
        
        int locationId = booking.getLocation().getId();
        if (stringId == null) 
        %>
        
        <form action="EditBookingController" method="post">
          <div class="row">
            <div class="col-sm-6">
              <div class="form-group">
                <div class="input-group date" id="startDate">
                  <input type="text" class="form-control" name="startDate"/>
                    <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div><br>
            
                <div class="input-group date" id="endDate">
                  <input type="text" class="form-control" name="endDate"/>
                    <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
               </div>
            </div>
           </div>
            
          <label>Location: </label> <select id="locationList" name="location">
          <% for (Location location : LocationDao.getInstance().getAllLocations()) { %>
            <option value="<%=location.getId()%>"><%=location.getLocationName()%></option> 
          <% } %>
          </select> <br/>
          
          <label>Additional Persons:</label> (comma separated email list) <input type="text" name="persons" value="<%=list %>"/>
        
          <input type="hidden" name="bookingId" value="<%=bookingId %>"/>
        <br><br>
        <button class="btn btn-info" id="editButton">Edit</button>
       </form>
    </div>
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.selecter.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.stepper.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.0/moment.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>
  <script>
    $("#locationList").val("<%=locationId %>");
    
    $(function() {
      var sd;
      var ed;
      $("#startDate").datetimepicker().on("dp.change", function(e) {
        sd = e.date;
        if(ed && sd && ed.diff(sd) < 0) {
        $("#startDate").data("DateTimePicker").date(ed);
        };
      });
      $("#endDate").datetimepicker().on("dp.change", function(e) {
        ed = e.date;
        if(ed && sd && ed.diff(sd) < 0) {
        $("#endDate").data("DateTimePicker").date(sd);
        };
      });;
      
      $("#startDate").data("DateTimePicker").date( moment("<%=startDate %>", "YYYY-MM-DD hh:mm:ss a") );
      $("#endDate").data("DateTimePicker").date( moment("<%=endDate %>", "YYYY-MM-DD hh:mm:ss a") );
    });
  </script>
</body>
</html>