package com.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
		String id=request.getParameter("id");
	
			Class.forName("com.mysql.cj.jdbc.Driver");

			response.setContentType("text/html");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/prac","root","subham");
			PreparedStatement ps=con.prepareStatement("select * from student_contacts where id= ?;");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			
			PrintWriter out=response.getWriter();
			
		out.println("<html><head>");
			
			while(rs.next()) {
				
			out.println("<form action='EditTable' method='POST'>");
		
			
			out.println("Id <input type='text' name='id' id='id' value='"+rs.getString(1)+"'/>");
			
			out.println("Name <input type='text' name='name' id='name' value='"+rs.getString(2)+"'/>");
		
			out.println("State <input type='text' name='state' id='state' value='"+rs.getString(3)+"'/>");
		
			out.println("Mail <input type='text' name='email' id='email' value='"+rs.getString(4)+"'/>");
			out.println("<input type='submit' value='Edit'>");
			out.println("</form>");
			
			}
			
			out.println("</body></html>");
		}
		catch(Exception e) {
			
		}
	}

}
