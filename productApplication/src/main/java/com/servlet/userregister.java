package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBconnection;

@WebServlet("/newuserregister")
public class userregister extends HttpServlet{

	protected void dopost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		PrintWriter pw =response.getWriter();	
		response.setContentType("text/html");
		
		
		
		try {
			 int userId=Integer.parseInt( request.getParameter("uid"));
			String name = request.getParameter("uname");
			String Email =request.getParameter("uemail");
			String Address = request.getParameter("uaddre"); 
			String Password = request.getParameter("upass");
			
			Connection con =DBconnection.getmyconn();
			PreparedStatement ps =con.prepareStatement("Insert into user details values ? ? ? ? ?");
		ps.setInt(1, userId);
		ps.setString(2, name);	
		ps.setString(3, Email);	
		ps.setString(5, Password);
		
		int result = ps.executeUpdate();
		
		if(result==1) {
			pw.print("user Register Successfully....");
			RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
			rd.include(request, response);
			
			
		}else {
			pw.print("user not Successfullly...");
			request.setAttribute("message", "user not register please correct details");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
			
		
	}
	
	
}
