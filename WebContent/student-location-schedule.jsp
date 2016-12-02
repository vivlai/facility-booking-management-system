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
      <h2>Facility Booking Management System</h2><br>
      <form action="">
        <label>Location: </label> 
        <select id="location">
          <option value="engineering">Engineering</option>
          <option value="math">Math</option>
          <option value="norlin">Norlin</option>
        </select><br><br>
        
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Time</th>
              <th>Mon</th>
              <th>Tue</th>
              <th>Wed</th>
              <th>Thur</th>
              <th>Fri</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>9:00 - 9:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>9:30 - 10:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>10:00 - 10:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>10:30 - 11:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>11:00 - 11:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>11:30 - 12:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>12:00 - 12:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>12:30 - 13:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>13:00 - 13:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>13:30 - 14:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>14:00 - 14:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>14:30 - 15:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>15:00 - 15:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>15:30 - 16:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>16:00 - 16:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>16:30 - 17:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>17:00 - 17:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>17:30 - 18:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>18:00 - 18:30</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>18:30 - 19:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>19:30 - 20:00</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>

        <br><br>
        <button class="btn btn-primary">Submit</button><br><br>
    </form>
    </div>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.selecter.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootflat/2.0.4/js/jquery.fs.stepper.min.js"></script>
</body>
</html>