package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
    public UpdateStudentServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	studentDao = new StudentDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		Student student = new Student();
		
		student.setId(id);
		student.setName(name);
		student.setMarks(marks);
		
		int noofRows = studentDao.updateStudent(student);
		if(noofRows > 0) {
			out.print("<h1> STUDENT UPDATE !!!</h1></hr></br>");

			response.sendRedirect(request.getContextPath() + "/readBook");
		}else {
			out.print("<h1> STUDENT FAILED TO UPDATE !!! </h1></hr></br>");
			request.getRequestDispatcher("index.html").include(request, response);
		}

	}

}
