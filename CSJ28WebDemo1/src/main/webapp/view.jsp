<%@page import="model.Student"%>
<%@page import="util.JpaUtil"%>
<%@page import="javax.persistence.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2" align="center">
<thead>
<th>RollNo</th>
<th>Name</th>
<th>dob</th>
<th>email</th>
<th>address</th>
<th>EDIT</th>
</thead>
<%
   EntityManager em=JpaUtil.getEntityManager();
  Query query= em.createQuery("select s from Student s");
  List<Student> student=   query.getResultList();
  for(Student s:student)
  { %>
  <tr>
  <td><%=s.getRollNo() %></td>
  <td><%=s.getName() %></td>
  <td><%=s.getDob() %></td>
  <td><%=s.getEmailId() %></td>
  <td><%=s.getAddress() %></td>
  <td><a href="UpdateServlet?p1=<%=s.getRollNo()%>&p2=<%=s.getAddress()%>">EDIT</a></td>
  <td><a href="DeleteServlet?p1=<%=s.getRollNo()%>">DELETE</a></td>
  </tr>
  <% } %>
</table>
</body>
</html>