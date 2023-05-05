package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.JpaUtil;

/**
 * Servlet implementation class FinalServlet
 */
public class FinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalServlet() {
        super();
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
		int id=Integer.parseInt(request.getParameter("id"));
		long ph=Long.parseLong(request.getParameter("phone"));
		String city=request.getParameter("city");
		
		EntityManager em=JpaUtil.getEntityManager();
		em.getTransaction().begin();
	Query q=em.createNamedQuery("updateQuery");
	 q.setParameter("p4", id);
	 q.setParameter("p2",city );
	 q.setParameter("p1", ph);
		 int status=q.executeUpdate();
		  em.getTransaction().commit();
		if(status>0)
		{
			response.sendRedirect("view.jsp");
		}
		else
		{
			out.println("not able to upadate");
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
