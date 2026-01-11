package Com.soft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFirst_Servlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Welcome to servlet programming......");
		
	}
	
}



