package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void 
	doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	out.println("Welcome to our page");
	//getParamater(string paramterName)---return String as parameter value
	String name=req.getParameter("t1");
	String dob=req.getParameter("t2");
	String email=req.getParameter("t3");
	String cityName=req.getParameter("t4");
	String gender=req.getParameter("t5");
	//getParameterValues(String input)---String[]
	String[] cs= req.getParameterValues("t6");
	
	String courses= " ";
	for(String s:cs)
	{
		courses=courses + " ,"+s;
	}
	
	out.print("<h1>"+name + " "+dob+ " "+email+ " "+cityName+ " "+gender+ " "+courses+"</h1>");
	
	
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
