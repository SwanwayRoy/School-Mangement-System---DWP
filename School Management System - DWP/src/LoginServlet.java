

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String User_name = request.getParameter("User_name");
		String password = request.getParameter("password");
		
		PreparedStatement ps;
		ResultSet rsx;
		
		try
		{
			//loading drivers for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");

			//creating connection with the database
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sms", "root", "ROOT");
			
			ps = con.prepareStatement
					("select * from user_account_details where User_name=? and password=?");
			ps.setString(1, User_name);
			ps.setString(2, password);
			rsx = ps.executeQuery();
			
			if(rsx.next() == false)
			{
				out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("Login.html");
				rs.include(request, response);
			}
			else
			{
				RequestDispatcher rs = request.getRequestDispatcher("Welcome.jsp");
				rs.forward(request, response);
			}
		}
		catch (Exception e)
		{
			System.out.println("Error in connection " + e);
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
