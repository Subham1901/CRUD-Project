package com.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		try {
		
			String id=request.getParameter("id");
			Class.forName("com.mysql.cj.jdbc.Driver");

			response.setContentType("text/html");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/prac","root","subham");
			PreparedStatement ps=con.prepareStatement("delete from student_contacts where id= ?;");
			ps.setString(1, id);
			PrintWriter out=response.getWriter();
			int x=ps.executeUpdate();
			out.println("<html><body>");
		
				out.println("<h>Deleted Successfully</h>");
				
						
			out.println("</body></html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
