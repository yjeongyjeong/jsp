package com.magic.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.magic.dao.EmployeesDAO.EmployeesDAO;
import com.magic.dto.EmployeesVO.EmployeesVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url = "member/login.jsp";
		
		EmployeesDAO mDao = EmployeesDAO.getInstance();
		/* 로그인 시 result 값에 따라 회원 구별
		 * 1 = 로그인 성공
		 * 0 = 암호 틀림
		 * -1 아이디 없음!!*/
		int result = mDao.userCheck(id, pwd);
		if( result == 1 ) {
			EmployeesVO vo = mDao.getEmployees(id); //getEmployees도 vo로 회원정보를 가져옴
			//로그인이 되는 회원이니까 브라우저가 꺼질 때까지 세션을 가져와서 유지되도록 함
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo); //vo라는 애한테 loginUser라는 이름을 붙여서 세션에 저장!-> attribute는 세션에 저장이 가능하고 parameter는 request에만 저장이 가능함
			request.setAttribute("message", "이 메세지는 언제 출력이 될까요? 필요가 있는 메세지일까요?");
			url = "member/main.jsp";
		} else if ( result == 0 ) { //아이디가 DB에 있지만 pwd가 다를 떄
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		} else if( result == -1 ) { //아이디가 존재하지 않을 때
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
		}

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	
	
	}
}
