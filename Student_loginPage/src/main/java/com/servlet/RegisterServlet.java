package com.servlet;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

	@WebServlet("/register")
	public class RegisterServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String pass = req.getParameter("password");

			try {
				Connection con = Database.getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO students(id,name,email,address,pass) VALUES (?,?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, address);
				ps.setString(5, pass);


				int i = ps.executeUpdate();

				if (i > 0) {
					req.setAttribute("msg", "Registration Successful!");
					req.getRequestDispatcher("success.jsp").forward(req, resp);
				} else {
					req.setAttribute("msg", "Registration Failed!");
					req.getRequestDispatcher("error.jsp").forward(req, resp);
				}

			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("msg", "Error: " + e.getMessage());
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		}
	}

