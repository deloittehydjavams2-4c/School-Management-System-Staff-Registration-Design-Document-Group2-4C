<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
	<script type="text/javascript">
	function formfunction()                                    
	{ 
	    var name = document.forms["RegForm"]["staff_Name"];               
	    var email = document.forms["RegForm"]["email_Id"];    
	    var phone = document.forms["RegForm"]["contact_Number"];    
	    var address = document.forms["RegForm"]["address"];  
	    var expr=document.forms["RegForm"]["experience"];
	    var country = document.forms["RegForm"]["country_Name"];
	    var state = document.forms["RegForm"]["state_Name"];
	    var yop = document.forms["RegForm"]["yop"];
		var todayDate = new Date();
	    var phoneno = /^\d{10}$/;
	    var pattern = /^[0-9]+$/;
	    var letters = /^[A-Za-z ]+$/;
		 var dojj=document.forms["RegForm"]["doj"];
		var dob=document.forms["RegForm"]["date_Of_Birth"];
		var date=new Date(dojj.value);
		var date2=new Date(dob.value);
		var todayDate = new Date();
		if (name.value == "")                                  
	    { 
	        window.alert("Error code 507 \n Staff Name : only alphabets and spaces are accepted e.g : deloitte USI"); 
	        name.focus(); 
	        return false; 
	    } 
	    if(!name.value.match(letters))
	      {
	   		window.alert("Error code 507 \n Staff Name : only alphabets and spaces are accepted e.g : deloitte USI"); 
	        name.focus(); 
	        return false; 
	   
	      }
	    if(date2 > todayDate){
			window.alert (" Error code 504 Enter a valid date of birth");
			return false;
			}
	    if (country.value == "Default")                                  
	    { 
	        window.alert("Please choose country name"); 
	        country.focus(); 
	        return false; 
	    } 
	    if (state.value == "Default")                                  
	    { 
	        window.alert("Please choose state name"); 
	        state.focus(); 
	        return false; 
	    } 
	    if (address.value == "")                               
	    { 
	        window.alert("Please enter your address."); 
	        address.focus(); 
	        return false; 
	    } 
	    if (phone.value == "")                           
	    { 
	        window.alert("Business Exception 506 \n please enter contact number"); 
	        phone.focus(); 
	        return false; 
	    } 
	    if(phone.value.length<10)
	    {
			window.alert("Business Exception 506 \n please enter 10 digit contact number");
	        phone.focus;
	        return false;
		}   
		
	  if(!phone.value.match(phoneno))
	        {
	        window.alert("Business Exception 506 \n contact number can contain only digits 0-9");
	        return false;
	        }
	  if (email.value == "")                                   
	    { 
	        window.alert("Business Exception 502 \n please enter your email id"); 
	        email.focus(); 
	        return false; 
	    } 
	   
	    if (email.value.indexOf("@", 0) < 0)                 
	    { 
	        window.alert("Business Exception 502 \n email must include @ "); 
	        email.focus(); 
	        return false; 
	    } 
	   
	    if (email.value.indexOf(".", 0) < 0)                 
	    { 
	        window.alert("Business Exception 502 \n please check your mail id"); 
	        email.focus(); 
	        return false; 
	    } 
	    if(!expr.value.match(pattern))
        {
        window.alert("Business Exception 509 \n Experience should be a valid number");
        return false;
        }
	    if(expr.value>37)
	    {
			window.alert("Business Exception 509 \n Experience must be less than 37 years.");
			expr.focus();
	        return false;
		}  
	    if (yop.value == "Default")                                  
	    { 
	        window.alert("Please choose year of passing"); 
	       	yop.focus(); 
	        return false; 
	    } 
		if (date < todayDate){
		window.alert (" Error code 504 Enter a valid date of joining");
		return false;
		} 
	  return true; 
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="new1.png" class="container">
<h1 style="color:blue"> <center> Welcome to Staff Registration Portal</center></h1>
<h3>Enter the Following Details</h3>
<form name="RegForm" action="addStaff" class="form-inline" onsubmit="return formfunction()"> 
<table class="table-condensed table-hover">
<tr><td>StaffName </td><td><input type="text" name="staff_Name" required></td></tr>
<tr><td>Date of  Birth </td><td><input type="Date" name="date_Of_Birth"></td></tr>
<tr><td>Country Name </td><td><select name="country_Name" required>
<option selected="" value="Default">(Please select a country)</option>
<option value="India">India</option>
<option value="USA">USA</option>
<option value="UK">UK</option>
<option value="Italy">Italy</option></select></td></tr>
<tr><td>State Name </td><td><select name="state_Name" required>
<option selected="" value="Default">(Please select a state)</option>
<option value="TamilNadu">TamilNadu</option>
<option value="Kerala">Kerala</option>
<option value="AndhraPradesh">Andhra Pradesh</option>
<option value="Karnataka">Karnataka</option>
<option value="Scottland">Scottland</option>
<option value="NewJersey">New Jersey</option>
<option value="Rome">Rome</option></select></td></tr>
<tr><td>Address </td><td><textarea rows="1" cols="50" name="address" required ></textarea></td></tr>
<tr><td>Contact Number </td><td><input type="text" name="contact_Number" size="10" required></td></tr>
<tr><td>Email Id</td><td><input type="text" name="email_Id" size="20" required></td></tr>
<tr><td>Gender</td><td><input type="radio" name="gender" value="F" required><span>Female</span>
<input type="radio" name="gender" value="M"><span>Male</span></td></tr>
<tr><td>Highest Qualification</td><td><input type="text" name="highest_Qualification" size="2" required></td></tr>
<tr><td>Designation</td><td><input type="text" name="designation" size="20" required></td></tr>
<tr><td>Experience</td><td><input type="text" name="experience" size="2" required></td></tr>
<tr><td>Year of Passing</td><td><select name="yop"  required>
<option selected="" value="Default">(Please select a year)</option>
<option value="2015">2015</option>
<option value="2016">2016</option>
<option value="2017">2017</option></select></td></tr>
<tr><td>Date of Joining</td><td><input type="date" name="doj" required></td></tr>
<tr><td><input type="submit" value="REGISTER" class="btn btn-success"></td><td><input type="reset" value="Reset" class="btn btn-warning"></td></tr>
</table>
</form>
</body>
</html>