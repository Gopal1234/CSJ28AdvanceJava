package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import util.JpaUtil;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Object getAttibute();
		
	//String name=(String)	request.getAttribute("user-Key");
	//String password=(String)	request.getAttribute("user-password");
		String name=request.getParameter("t1");
		String password=request.getParameter("t2");
	PrintWriter pw=response.getWriter();
	
	EntityManager em=JpaUtil.getEntityManager();
	Query query=em.createQuery("select s from Student s");
	   List<Student> list=query.getResultList();
	   int flag=0;
	   for(Student s: list)
	   {
		   String userName=s.getName();
		   String userPassword=s.getPassword();
		   if(name.equals(userName) && password.equals(userPassword))
		   {
			  flag=1;
			  break;
		   }
				   
	   }
	
	
	pw.println("Thank you" + name+ " "+" for Registration");
	if(flag==1)
	{
		response.sendRedirect("next.jsp");
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
	//pw.println("")
	
	
		
		
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
