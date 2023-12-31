package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//브라우저에서 로그인하면 여기서 받아서 login.jsp로 보내주고 login.jsp에서 다시 자료를 이 서블렛으로 받아와서 브라우저로 전송
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
//		System.out.println(userid);
//		System.out.println(pwd);
		
		MemberDAO mDao = MemberDAO.getinstance(); //싱글톤이라 메서드로 가져옴
		int result = mDao.userCheck(userid, pwd);
		
		if(result == 1 ) { //로그인 성공
			MemberVO mVo = mDao.getMember(userid);
//			System.out.println(mVo); : getMember가 되는지 확인
//			memberVO객체로 해당하는 컬럼들 받아올 수 있는지 확인-> 출력 시 memberVO 변수들이 출력됨
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url = "main.jsp";
			
		} else if(result == 0) { //pwd x
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if(result == -1) { //id x
			request.setAttribute("message", "존재하지 않는 회원입니다.");			
		}
		//로그인 성공하면 url감
		request.getRequestDispatcher(url).forward(request, response);
	}

}
