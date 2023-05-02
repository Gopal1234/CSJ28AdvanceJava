package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import util.JpaUtil;

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
	//PrintWriter getWriter()	
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
	String s1=email.substring(1,2);
	String s2=dob.substring(1,3);
	String finalPassword=s1+s2;
	
	
	EntityManager em=JpaUtil.getEntityManager();
	em.getTransaction().begin();
	Student student=new Student();
	student.setName(name);
	student.setAddress(cityName);
	student.setDob(LocalDate.parse(dob));
	student.setEmailId(email);
	student.setGender(gender);
	student.setCourses(courses);
	student.setPassword(finalPassword);
	em.persist(student);
	
	em.getTransaction().commit();
	
	
	
	
	
	/*out.print("<h1>"+name + " "+dob+ " "+email+ " "+cityName+ " "+gender+ " "+courses+"</h1>");
	//setAttibute(String keyName, Object value)
	req.setAttribute("user-key", name);
	req.setAttribute("user-password", finalPassword);*/
	
	out.println("<a href='login.jsp'>Login Here</a>");
	
	
	
	
	
	
	/*RequestDispatcher rd=req.getRequestDispatcher("SecondServlet");
	rd.forward(req, res);*/
	
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
