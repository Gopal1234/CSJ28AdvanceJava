package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JpaUtil;

/**
 * Servlet implementation class FinalUpdateServlet
 */
public class FinalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int rollNo=Integer.parseInt(request.getParameter("t1"));
		 String address=request.getParameter("t2");
		 EntityManager em=JpaUtil.getEntityManager();
		 em.getTransaction().begin();
		 Query q=em.createNamedQuery("updateQuery");
		 q.setParameter("p1",address);
		 q.setParameter("p2", rollNo);
		 int status=q.executeUpdate();
		 em.getTransaction().commit();
		 if(status>0)
		 {
			 response.sendRedirect("view.jsp");
		 }
		 else
		 {
			 out.println("<h1>Error in update</h1>");
		 }
		 
		 
		 
		 
		 
		
		
	}

}
