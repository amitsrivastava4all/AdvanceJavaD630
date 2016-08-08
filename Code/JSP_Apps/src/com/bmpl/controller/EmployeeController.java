package com.bmpl.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.dto.EmployeeDTO;
import com.bmpl.models.EmployeeModel;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/empctrl")
public class EmployeeController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double salary = Double.parseDouble(request.getParameter("salary"));
		EmployeeModel model =new EmployeeModel();
		ArrayList<EmployeeDTO> searchResult = model.search(salary);
		request.setAttribute("searchdata", searchResult);
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

}
