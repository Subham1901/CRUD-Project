package com.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditTable")
public class EditTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		try {
		
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String state=request.getParameter("state");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/prac","root","subham");
			PreparedStatement ps=con.prepareStatement("update student_contacts set name=? ,state=?,email=? where id=?  ; ");
			
			
			ps.setString(1, name);
			ps.setString(2, state);
			ps.setString(3, email);
			ps.setString(4, id);
			
			
			
			
			int x=ps.executeUpdate();
			out.println("<html><body>");
		
				out.println("<h1>Record has been Updated...</h1>");
				  RequestDispatcher rd = request.getRequestDispatcher("AllData");
		           rd.forward(request, response);
				
			out.println("</body></html>");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
