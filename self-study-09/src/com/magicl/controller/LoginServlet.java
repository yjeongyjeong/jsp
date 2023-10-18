package com.magicl.controller;

// 커밋하고 확인하기...

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url = null;

		EmployeesDAO empDAO = EmployeesDAO.getInstance();
		System.out.println(" empDAO :  " + empDAO);
		int result = empDAO.userCheck(id, pwd, lev);
		if (result == 2 || result == 3) {
			EmployeesVO emp = new EmployeesVO();
			emp = empDAO.getMember(id);

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", emp);
			session.setAttribute("result", result);
			url = "main.jsp";
		} else {
			url = "login.jsp";
			if (result == 1) {
				request.setAttribute("message", "result == 1 레벨 불일치");
			} else if (result == 0) {
				request.setAttribute("message", "result == 비밀번호 불일치");
			} else {
				request.setAttribute("message", "else");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
