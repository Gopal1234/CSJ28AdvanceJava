package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import utility.JpaUtil;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet(value = "/pack1.MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		
		String userName=request.getParameter("t1");
		String password=request.getParameter("t2");
		String rememberValue=request.getParameter("remember");
		System.out.println(rememberValue);
	EntityManager em=JpaUtil.getEntityManager();
		 Query query= em.createQuery("select s from Student s");
		int flag=0;
		List<Student> students=  query.getResultList();
		for(Student s:students)
		{
			if(userName.equals(s.getStudentName() )&& password.equalsIgnoreCase(s.getStudentPassord()))
					{
				  flag=1;
				  break;
					}
		}
		
		
		
		
		
		if(  userName!=null && password!=null && flag==1)
			
		{
			//response.sendRedirect("next.jsp");
			if(request.getParameter("remember")!=null)
			{
			String remember = request.getParameter("remember");
			Cookie cUserName = new Cookie("cookuser", userName.trim());
			Cookie cPassword = new Cookie("cookpass", password.trim());
			Cookie cRemember = new Cookie("cookrem", remember.trim());
			cUserName.setMaxAge(60 * 60 * 24 * 15);//86400  15 days
			cPassword.setMaxAge(60 * 60 * 24 * 15);
			cRemember.setMaxAge(60 * 60 * 24 * 15);
			response.addCookie(cUserName);
			response.addCookie(cPassword);
			response.addCookie(cRemember);
			}
			HttpSession httpSession = request.getSession();
			//httpSession.setMaxInactiveInterval(10000);
			httpSession.setAttribute("sessuser", userName.trim());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			System.out.println("Authentication failure.");
			request.setAttribute("msg", "Authentication failure.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);	
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
