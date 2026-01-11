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

import com.db.DBConnection;

@WebServlet("/addnewproduct")
public class AddNewProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			
			try {
				
				int pid = Integer.parseInt(request.getParameter("pid"));
				String pname = request.getParameter("pname");
				int qty = Integer.parseInt(request.getParameter("pqty"));
				String price = request.getParameter("price");
				
				Connection con = DBConnection.getMyConn();
				
				PreparedStatement ps = con.prepareStatement("insert into product_details values(?,?,?,?)");
				ps.setInt(1, pid);
				ps.setString(2, pname);
				ps.setInt(3, qty);
				ps.setString(4, price);
				
				int result = ps.executeUpdate();
				if(result==1) {
					RequestDispatcher rd = request.getRequestDispatcher("allproduct");
					rd.forward(request, response);
					
				}else {
					request.setAttribute("Message", "Product not inserted please correct all details");
					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
