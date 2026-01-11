package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.db.DBConnection;

@WebServlet("/allproduct")
public class GetAllProductServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			
			try {
				
				Connection con = DBConnection.getMyConn();
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery("Select * from product_details");
				
				ArrayList<Product> al = new ArrayList<Product>();
				
				while(rs.next()) {
					Product product = new Product();
					product.setPid(rs.getInt(1));
					product.setPname(rs.getString(2));
					product.setQty(rs.getInt(3));
					product.setPrice(rs.getString(4));
					al.add(product);
					
				}
				
				request.setAttribute("allproduct", al);
				
				RequestDispatcher rd = request.getRequestDispatcher("productdashboard.jsp");
				rd.forward(request, response);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
	}
}
