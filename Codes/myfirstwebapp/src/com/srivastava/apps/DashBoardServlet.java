package com.srivastava.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashBoardServlet
 */
public class DashBoardServlet extends HttpServlet {
	
	private ServletConfig sc ;
	public void init(ServletConfig sc) throws ServletException{
		super.init(sc);
		this.sc = sc;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// Want to use the Existing Session
		HttpSession session = request.getSession(false);
//		if(session == null){
//			response.sendRedirect("login.html");
//		}
//		else{
		String emailId = sc.getInitParameter("email");  // get config 
		String globalEmailId = sc.getServletContext().getInitParameter("email"); // get context
			String uid = (String)session.getAttribute("userid");
		String color="white";
		Cookie cookie[] = request.getCookies();
		if(cookie!=null && cookie.length>0){
			for(Cookie c : cookie){
				if(c.getName().equals("myfavcolor")){
					color = c.getValue();
					//isCookieFound=true;
					break;
				}
			}
		}
			//String uid = request.getParameter("userid");
		
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		RequestDispatcher rd = request.getRequestDispatcher("HeaderServlet");
		rd.include(request, response);
		//out.println("<body bgcolor='"+color+"'>");
		out.println("Config Email is "+emailId+" Context Email is "+globalEmailId);
		out.println("<form action='logout'><input type='submit' value='logout'></form>");
		out.println("Welcome "+uid+" Branch is "+request.getParameter("branch"));
		out.println("Account Summary is ");
		out.println("<br><form action='Page2'><input type='submit' value='Click to Go Page2'></form>");
		RequestDispatcher rd2 = request.getRequestDispatcher("Footer");
		rd2.include(request, response);
		out.close();
		//}
	}

}
