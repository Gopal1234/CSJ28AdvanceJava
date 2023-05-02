<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! List<String> listOfDetails=new ArrayList(); %>
<%
  listOfDetails=(List<String>) application.getAttribute("update-key");
%>
<table border="2">
<form action="FinalUpdateServlet" method="post">
Student RollNumber:<input type="hidden" name="t1" value='<%=Integer.parseInt(listOfDetails.get(0))
%>'><br>
 
 Student Address:<input type="text" name="t2" value='<%=listOfDetails.get(1) %>'><br>
 <input type="submit" value="update">

</form>
</table>
</body>
</html>