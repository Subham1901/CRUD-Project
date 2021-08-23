package com.connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/AllData")
public class AllData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String cssLocation = request.getContextPath() + "/style.css";
		    String cssTag = "<link rel='stylesheet' type='text/css' href='" + cssLocation + "'>";
			
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/prac","root","subham");
			PreparedStatement ps=con.prepareStatement("Select * from student_contacts");
			ResultSet rs=ps.executeQuery();
			
			PrintWriter out=response.getWriter();
			
			
			out.println("<html><head><title>Title Name</title>"+cssTag+"</head>");
			out.println("<body>");

			out.println("<center><table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>name</th>");
			out.println("<th>state</th>");
			out.println("<th>Email</th>");
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th>");
			while(rs.next()) {
				
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>" +"<a href='Edit?id="+rs.getString("id")+"'>Edit</a>"+"</td>");
				out.println("<td>" +"<a href='Delete?id="+rs.getString("id")+"'>Delete</a>"+"</td>");
				out.println("</tr>");
				
			}
			
			out.println("</center>");
			out.println("</table></body></html>");
			
			
		}
		
		catch(Exception e){
		e.printStackTrace();
	}
		
	}

}
