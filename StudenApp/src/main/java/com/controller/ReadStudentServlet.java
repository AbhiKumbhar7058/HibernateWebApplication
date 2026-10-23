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

import java.util.List;

@WebServlet("/readStudent")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StudentDao studentDao;
    public ReadStudentServlet() {
        super();
        }
    @Override
    public void init() throws ServletException {
    	studentDao = new StudentDaoImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = studentDao.getAllStudent();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.setAttribute("studentList", studentList);
		
		out.print("<table border='border: 1px solid #dddddd;'>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> Marks </th>");
		out.print("<th> DELETE </th>");
		out.print("<th> UPDATE </th>");
		out.print("</tr>");
		for (Student student : studentList) { 
			out.print("<tr>");
			out.print("<td>" + student.getId() + "</td>");
			out.print("<td>" + student.getName() + "</td>");
			out.print("<td>" + student.getMarks() + "</td>");
			out.print("<td>");
			out.print("<a href='deleteStudent?id="+student.getId()+"'>"+" DELETE "+"</a>");
			out.print("</td>");
			out.print("<td>");
			out.print("<a href='updateFromStudentServlet?id="+student.getId()+"'>"+" UPDATE "+"</a>");
			out.print("</td>");
			out.print("</tr>");
		}

		out.print("</table>");
	}

}
