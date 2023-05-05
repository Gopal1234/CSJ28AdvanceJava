<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! List<String> listOfDetails=new ArrayList(); %>


<%

listOfDetails= (List<String>)application.getAttribute("update-key");
%>
<center>
<form action="FinalServlet" method="post">
<table border="2" style=background-color:skyblue;>
<tr>

<label for="id"></label>
<input type="hidden" name="id" value='<%=Integer.parseInt(listOfDetails.get(0)) %>'><br>

<label for="phone"></label>
<input type="text" name="phone" value='<%=Long.parseLong(listOfDetails.get(1)) %>'><br>

<label for="city"></label>
<input type="text" name="city" value='<%=listOfDetails.get(2)%>'><br>
<input type="submit" value="UPDATE">

</tr>
</table>
</form>
</center>
</body>
</html>