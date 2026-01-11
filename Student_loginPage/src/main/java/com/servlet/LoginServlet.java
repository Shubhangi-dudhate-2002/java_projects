package com.servlet;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        String email = req.getParameter("email");
	        String password = req.getParameter("password");

	        try {
	            Connection con = Database.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                    "SELECT * FROM students WHERE email=? AND pass=?");

	            ps.setString(1, email);
	            ps.setString(2, password);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                req.setAttribute("msg", "Login Successful!");
	                req.getRequestDispatcher("success.jsp").forward(req, resp);
	            } else {
	                req.setAttribute("msg", "Invalid Credentials!");
	                req.getRequestDispatcher("error.jsp").forward(req, resp);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            req.setAttribute("msg", "Error: " + e.getMessage());
	            req.getRequestDispatcher("error.jsp").forward(req, resp);
	        }
	    }
	}

