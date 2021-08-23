package com.insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String state=request.getParameter("state");
			String email=request.getParameter("email");
		
			
			response.setContentType("text/html");
			
			 Class.forName("com.mysql.jdbc.Driver");    
	            String url="jdbc:mysql://localhost/prac";    
	            String user="root";    
	            String password="subham";    
	               PrintWriter pw;
	               pw=response.getWriter();
	            Connection con=DriverManager.getConnection(url, user, password);    
	            String query="Insert into student_contacts value (?,?,?,?);";    
	            PreparedStatement pstmt=con.prepareStatement(query);    
	            pstmt.setString(1, id);    
	            pstmt.setString(2, name);    
	            pstmt.setString(3,state);    
	            pstmt.setString(4, email);    
	             
	                
	            int x=pstmt.executeUpdate();    
	        	pw.println("<html><body>");
	            if(x==1)    
	            {    
	            
	            pw.println("<b>Values Inserted Successfully</b>");   
	            
	            }  
	        
	            pw.println("</body></html>");  
	            RequestDispatcher rd = request.getRequestDispatcher("AllData");
	            rd.forward(request,response);
		
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}


