package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//instantiating the servletconfig
		
ServletConfig config=getServletConfig();
		
		 String userName=config.getInitParameter("userName");
		 String password=config.getInitParameter("password");
		//this is to fetch all parameter names  
	Enumeration e=	 config.getInitParameterNames();
		 while(e.hasMoreElements())
		 {
			 String str=(String)e.nextElement();
			 String values=config.getInitParameter(str);
			 System.out.println(str+ " "+ values);
		 }
		 String un=request.getParameter("t1");
		 String pw=request.getParameter("t2");
		 
		if(un.equals(userName) && pw.equals(password))
		{
			response.sendRedirect("next.jsp");
		}
		else
		{
			response.sendRedirect("error.jsp");	
		}

		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
