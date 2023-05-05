package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import utility.JpaUtil;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("t1");
		String dob=request.getParameter("t3");
		String city=request.getParameter("t4");
		String gender=request.getParameter("t5");
		String[] courses=request.getParameterValues("t6");
		String phone=request.getParameter("t7");
		String c=" ";
		for(int i=0; i<courses.length; i++) {
			c=c+", "+courses[i];
		}
			
		out.println("<h1>"+name + " "+dob+ " "+city + " "+gender+ " "+c + " "+phone +"</h1>");
	
		
		String s1=dob.substring(dob.length()-2);
		String s2=phone.substring(phone.length()-4);
		String s3=name.substring(1,3);
		String finalPassword=s1.concat(s2).concat(s3);
		out.println("your password is" + " "+s1.concat(s2).concat(s3));
		
		EntityManager em=JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Student student=new Student();
		student.setStudentName(name);
		student.setDob(LocalDate.parse(dob));
		student.setCityAddress(city);
		student.setCourses(c);
		student.setGender(gender);
		student.setPhoneNumber(Long.parseLong(phone));
		student.setStudentPassord(finalPassword);
		
		em.persist(student);
		em.getTransaction().commit();
		request.setAttribute("user-name", name);
		request.setAttribute("user-pass", finalPassword);
		
		RequestDispatcher rd=request.getRequestDispatcher("/SecondServlet");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
