import java.io.IOException;
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

		PreparedStatement ps;
		ResultSet rsx;

		try
		{
			//loading drivers for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");

			//creating connection with the database
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sms", "root", "root");

			ps = con.prepareStatement
					("select * from user_account_details");
			rsx = ps.executeQuery();

			if (rsx != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("data",rsx);
				RequestDispatcher rd = request.getRequestDispatcher("/DisplayUser.jsp");
				rd.forward(request, response);					
			}
			else
			{
				System.out.println("No Data found");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
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