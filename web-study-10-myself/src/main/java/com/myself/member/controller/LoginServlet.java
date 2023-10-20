package com.myself.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myself.member.dao.MemberDAO;
import com.myself.member.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//첫화면이니까 딱히 받아오거나.. 생각할만한게 없음... 따라서 그냥 login.jsp로 갈 수 있도록 dispatcher & forward해줌
		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		dis.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "member/login.jsp";
		
//		로그인 로직 : 먼저 아이디와 패스워드를 입력받고 db에 둘 다 전달해서 일치하면(userCheck) getMember라는 메서드를 통해 아이디를 넣고 정보를 가져와서 세션에 로그인 된 회원의 정보를 저장함 
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance(); //다른데서 객체 만들기 불가능. 가져오기만 가능함
		int result =  mDao.userCheck(userid, pwd); //결과값이 1, 0, -1로 반환됨
		System.out.println(result);
		if(result == 1) {
			MemberVO vo = mDao.getOneMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			url = "member/main.jsp";
		} else if(result == 0) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			System.out.println(userid);
			System.out.println(pwd);
		} else if(result == -1) {
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
			System.out.println(userid);
			System.out.println(pwd);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
