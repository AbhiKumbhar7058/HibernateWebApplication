package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;

@WebServlet("/UpdateFormStudentServlet")
public class UpdateFormStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

	public UpdateFormStudentServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		studentDao = new StudentDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Student student = studentDao.getStudentByid(id);

		request.setAttribute("student", student);

		request.getRequestDispatcher("updateDtudent.jsp").forward(request, response);

	}
}
