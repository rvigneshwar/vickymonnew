package com.ibm.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.DepartmentDAO;
import com.ibm.model.Department;

@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int locId=Integer.parseInt(request.getParameter("loc"));
		
		DepartmentDAO dao = new DepartmentDAO();
		ArrayList<Department> depts = dao.getDeptbyLoc(locId);
		
		request.setAttribute("depts", depts);
 	
	RequestDispatcher disp = request.getRequestDispatcher("DepartmentList2.jsp");
	disp.forward(request, response);
	}

}
