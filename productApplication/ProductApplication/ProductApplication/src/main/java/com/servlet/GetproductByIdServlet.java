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
import javax.servlet.annotation.WebServlet;

import com.bean.Product;
import com.db.DBConnection;

@WebServlet("/getproductById")
public class GetproductByIdServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			int pid = Integer.parseInt(req.getParameter("pid"));
			
			Connection con = DBConnection.getMyConn();
			PreparedStatement ps = con.prepareStatement("select * from product_details where pid=?");
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Product product = new Product();
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setQty(rs.getInt(3));
				product.setPrice(rs.getString(4));
				
				req.setAttribute("existingproduct", product);
				RequestDispatcher rd = req.getRequestDispatcher("editproduct.jsp");
				rd.forward(req, res);
			}else {
				req.setAttribute("Message", "Product not found with pid..");
				RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
				rd.forward(req, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
