<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SignUpServlet" method="post">
Enter Name:<input type="text" name="t1"><br>
Enter DOB :<input type="date" name="t3"><br>
Enter city:<select name="t4">
<option value="PUNE">Pune</option>
<option value="KOLKATA">kolkata</option>
<option value="Delhi">Delhi</option>
<option value="Chennai">Chennai</option>
<option value="Bangalore">Bangalore</option>
<option value="Chandigarh">Chandigarh</option>
</select><br>
Enter Gender:<input type="radio" name="t5" value="male">
            <input type="radio" name="t5" value="female"><br>
            
Enter Course:<input type ="checkbox" name="t6" value="java">JAVA   
 <input type ="checkbox" name="t6" value="C#">C#
 <input type ="checkbox" name="t6" value="JEE">JEE
 <input type ="checkbox" name="t6" value="Hibernate">Hibernate 
 <br>
 Enter phoneNumber:<input type="text" name="t7"><br>
 <input type="submit" value="SignUp">               
</form>
</body>
</html>