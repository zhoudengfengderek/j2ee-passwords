package com.derek.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.derek.model.Contants;
import com.derek.model.DBHelper;
import com.derek.model.User;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = DBHelper.getUserFromDB(username);
		if (user != null && user.getPassword() != null) {
			if (user.getPassword().equals(password)) {
				response.getWriter().write(user.getUserId() + "");
			} else {
				response.getWriter().write(Contants.FAIL_STATUS + "");
			}
		} else {
			response.getWriter().write(Contants.FAIL_STATUS + "");
		}
	}
}
