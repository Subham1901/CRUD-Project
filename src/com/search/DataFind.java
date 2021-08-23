package com.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int id=Integer.parseInt(name);
		try {
		String cssLocation = request.getContextPath() + "/style.css";
	    String cssTag = "<link rel='stylesheet' type='text/css' href='" + cssLocation + "'>";
	
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/prac","root","subham");
			PreparedStatement ps=con.prepareStatement("select * from student_contacts where id= "+id+"");
			ResultSet rs=ps.executeQuery();
			
			PrintWriter out=response.getWriter();
			
		out.println("<html><head><title>Title Name</title>"+cssTag+"</head>");
			out.println("<html>");
			out.println("<body>");
			out.println("<center><table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>name</th>");
			out.println("<th>state</th>");
			out.println("<th>Email</th>");
			while(rs.next()) {
				
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
			out.println("</center>");
			out.println("</table></body></html>");
		}
		catch(Exception e) {
			
		}
	}
}


