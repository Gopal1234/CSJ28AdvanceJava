package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.JpaUtil;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("param1");
		String phone=request.getParameter("param2");
		String city=request.getParameter("param3");
		out.println(id + " "+phone+ " "+city);
		ServletContext context =getServletContext();
		
		
		List<String> listOfDetails=new  ArrayList();
		listOfDetails.add(id);
		listOfDetails.add(phone);
		listOfDetails.add(city);
		context.setAttribute("update-key",listOfDetails);
	out.println("Going for Update............");
		//RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		//rd.include(request, response);
	response.sendRedirect("update.jsp");
		//EntityManager em=JpaUtil.getEntityManager();
		
	//	Query query=em.createNamedQuery("updateQuery");
	//	query.setParameter("p1", query)
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
