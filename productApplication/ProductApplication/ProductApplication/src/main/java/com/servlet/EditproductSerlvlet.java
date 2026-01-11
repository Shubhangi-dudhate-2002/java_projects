package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.db.DBConnection;

@WebServlet("/editproduct")
public class EditproductSerlvlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			
			String pname = req.getParameter("pname");
			int qty = Integer.parseInt(req.getParameter("pqty"));
			String price = req.getParameter("price");
			int pid = Integer.parseInt(req.getParameter("pid"));
			
			Connection con = DBConnection.getMyConn();
			PreparedStatement ps = con.prepareStatement("update product_details set pname=?,qty=?,price=? where pid=?");
			ps.setString(1, pname);
			ps.setInt(2, qty);
			ps.setString(3, price);
			ps.setInt(4, pid);
			
			int result = ps.executeUpdate();
			
			if(result==1) {
				RequestDispatcher rd = req.getRequestDispatcher("allproduct");
				rd.forward(req, res);
				
			}else {
				req.setAttribute("Message", "Product not updated with pid..");
				RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
				rd.forward(req, res);
			}
			
		} catch (Exception e) {
		
		}
		
	}

}
