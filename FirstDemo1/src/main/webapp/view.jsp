<%@page import="utility.JpaUtil"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.persistence.*,java.util.*, java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String name;
  LocalDate dob;
  String city;
  String gender;
  long phone;
  String course;

%>
<table border="1" align="center">
<thead>
<th>name</th>
<th>dob</th>
<th>city</th>
<th>gender</th>
<th>phone</th>
<th>course</th>
</thead>
<%
  EntityManager em=JpaUtil.getEntityManager();
      Query q=  em.createQuery("select s from Student s");
           List<Student> student=q.getResultList();
 for(Student s:student)
 { %>
	 <tr>
	 <td><%=s.getStudentId()%></td>
	  <td><%=s.getDob()%></td>
	   <td><%=s.getCityAddress()%></td>
	   <td><%=s.getGender()%></td>
	      <td><%=s.getPhoneNumber()%></td>
	         <td><%=s.getCourses()%></td>
	         <td><a href="UpdateServlet?param1=<%=s.getStudentId()%>&param2=<%=s.getPhoneNumber()%>&param3=<%=s.getCityAddress()%>">EDIT</a></td>
	 
	 </tr>
	 
	 
	 
	 
 <% }


%>
</table>
</body>
</html>