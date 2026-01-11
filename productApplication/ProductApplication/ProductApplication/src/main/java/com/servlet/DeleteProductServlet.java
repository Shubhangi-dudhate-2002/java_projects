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

@WebServlet("/deleteproduct")
public class DeleteProductServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			
			int pid = Integer.parseInt(req.getParameter("pid"));
			
			Connection con = DBConnection.getMyConn();
			
			PreparedStatement ps = con.prepareStatement("delete from product_details where pid=?");
			ps.setInt(1, pid);
			
			int result = ps.executeUpdate();
			
				if(result==1) {
					RequestDispatcher rd = req.getRequestDispatcher("allproduct");
					rd.forward(req, res);
					
				}else {
					req.setAttribute("Message", "Product not deleted..");
					RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
					rd.forward(req, res);
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
