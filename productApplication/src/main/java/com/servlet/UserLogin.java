package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.db.DBconnection;

public class UserLogin extends GenericServlet{
	protected void doget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			PrintWriter pw =response.getWriter();	
			response.setContentType("text/html");
			
			
			try {
				
			String email = request.getParameter("uemail");
				String password = request.getParameter("upass");
				
				Connection con = DBconnection.getmyconn();
				PreparedStatement ps =con.prepareStatement("select * from user_details where email=? AND password =? ");
				ps.setString(1, email);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					User user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setAddress(rs.getString(4));
					user.setPassword(rs.getString(5));
					
					request.setAttribute("loggeduser", user);
					
					RequestDispatcher rd = request.getRequestDispatcher("productDashboard.jsp");
					rd.forward(request, response);
					
				}else {
					request.setAttribute("message", "please check email and password");
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}


