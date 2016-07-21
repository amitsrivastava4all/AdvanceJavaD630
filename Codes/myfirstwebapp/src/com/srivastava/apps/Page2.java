package com.srivastava.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page2
 */
public class Page2 extends HttpServlet {
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
		String emailId = sc.getInitParameter("email");
		String globalEmailId = sc.getServletContext().getInitParameter("email");
		out.println("Config Email is "+emailId+" Context Email "+globalEmailId);
	}

}
