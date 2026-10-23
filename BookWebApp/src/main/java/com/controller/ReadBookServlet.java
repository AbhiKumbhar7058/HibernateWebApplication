package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.entity.*;


@WebServlet("/readBook")
public class ReadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
    public ReadBookServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	bookDao = new BookDaoImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> bookList = bookDao.findAllBook();
		
		request.setAttribute("bookList", bookList);
		
		request.getRequestDispatcher("readBook1.jsp").forward(request, response);
		
		
		
	}

}
