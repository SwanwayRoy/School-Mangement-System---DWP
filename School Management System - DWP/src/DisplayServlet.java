import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
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
		PrintWriter out = response.getWriter();
		
		PreparedStatement ps;
		ResultSet rsx = null;

			try
			{
				//loading drivers for mysql
				Class.forName("com.mysql.cj.jdbc.Driver");

				//creating connection with the database
				Connection con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/sms", "root", "ROOT");
				
				ps = con.prepareStatement
						("select * from user_account_details");
				rsx = ps.executeQuery();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
			
		if (rsx != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("data",rsx);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayUser.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("Error");
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