<html>
<center>
<body bgcolor="SkyBlue">
<%
	    Cookie[] cookies=request.getCookies();
	    String userName = "", password = "",rememberVal="";
	    if (cookies != null) {
	         for (Cookie cookie : cookies) {
	           if(cookie.getName().equals("cookuser")) {
	             userName = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookpass")){
	             password = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookrem")){
	             rememberVal = cookie.getValue();
	           }
	        }
	    }
	%>



<img src="cyberimg.png" align="top">
<h2>Hello World!</h2>
  <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
<form action="MyServlet">

User Name:<input type="text" name="t1" value="<%=userName%>"><br>
Password:<input type="password" name="t2" value="<%=password%>"><br>

<label>Remember</label>
 <input type="checkbox" name="remember"value="1"
 <%= "1".equals(rememberVal.trim()) ? "checked=\"checked\"" : "" %> />
               


<input type="submit" value="Login">


</form>




</body>
</center>
</html>
