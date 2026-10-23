package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BookDao bookDao;
    public DeleteBookServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	bookDao = new BookDaoImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		int noofRows = bookDao.deleteBookById(id);
		
		if(noofRows > 0) {
			response.sendRedirect(request.getContextPath()+"/readBook");
			
		}else {
			out.print("<h1> BOOK Failed To Delete !!!</h1></hr></br>");
		}
	}

}
