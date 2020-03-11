<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="design.css" rel="stylesheet" />
</head>
<body>
	<header>
		<img src="logo1.jpg" align="left" width="184px" height="126px">
		<h2>School Management System</h2>
	</header>

	<section>
		<nav>
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="form.html">Registration</a></li>
				<li><a href="#">Contact Us</a></li>

			</ul>
		</nav>

		<table border="1" cell padding="10">
			<tr bgcolor="blue">
				<th>User Name</th>
				<th>User Role</th>
			</tr>
			<%@ page import="java.sql.*"%>
			<%! ResultSet rs = null; %>
			<%
rs=(ResultSet)session.getAttribute("data");
if(rs==null)
	out.println("Data not found");
else
{
	while(rs.next())
	{
		out.println("<tr bgcolor=red><td>" +rs.getString ("User_name") + "</td><td>" + 
	rs.getString("user_role") + "</td></tr>");
	}
}
%>
		</table>

	</section>

	<footer>
		<p>Alpha School Management System</p>
	</footer>
</body>
</html>