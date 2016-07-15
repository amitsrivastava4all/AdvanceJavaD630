package com.srivastava.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Step - 1 Your Servlet Class Must Inherit HttpServletClass
public class WelcomeServlet extends HttpServlet {
	private int counter; // this is servlet instance variable
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Servlet Destroy Call");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		counter = 1;
		System.out.println("Servlet Init Call");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet Service Call");
		String uid = request.getParameter("userid");
		String password = request.getParameter("password");
		PrintWriter out =response.getWriter();
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserid(uid);
		loginDTO.setPassword(password);
		try{
		if(loginDAO.isUserExist(loginDTO)){
			// Create a New Session
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", uid);
			// sendredirect doesn't carry the data
			// it create a fresh request and it always need doGet
			//RequestDispatcher rd = request.getRequestDispatcher("dashboard");
			//rd.forward(request, response);
			response.sendRedirect("dashboard");
			//response.sendRedirect("dashboard?userid="+uid); //querystring
			//out.println("Welcome User "+uid);
		}
		else
		{
			out.println("Invalid Userid or Password");
		}
		}
		catch(Exception e){
			response.sendRedirect("error.html");
			System.out.println(e);
			e.printStackTrace();
			
		}
//		if(uid.equals(password)){
//			out.println("Welcome User "+uid);
//		}
//		else
//		{
//			out.println("Invalid Userid or Password");
//		}
		//out.println("Hello User Hit Count is "+counter);
		//counter++;
		out.close();
	}

}
