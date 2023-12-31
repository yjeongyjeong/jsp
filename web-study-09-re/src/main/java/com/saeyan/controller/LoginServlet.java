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


@WebServlet("/login.do") //.jsp는 안쳐도 됨 jsp아니니까..
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
  		dis.forward(request, response);
  	}

  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		request.setCharacterEncoding("utf-8"); //한글 넣으면 깨져서 인코딩해줌
  		String userid = request.getParameter("userid");
  		String pwd = request.getParameter("pwd");
  		String url = "member/login.jsp";
  		
//  		System.out.println(userid);
//  		System.out.println(pwd);
  		MemberDAO mDao = MemberDAO.getInstance();
//  		result == 1 => 로그인 성공
//  		result == 0 => 암호 틀림
//  		result == -1 => 아이디 틀림
//  		로그인 로직 : 먼저 아이디와 패스워드를 입력받고 db에 둘 다 전달해서 일치하면(userCheck) getMember라는 메서드를 통해 아이디를 넣고 정보를 가져와서 세션에 로그인 된 회원의 정보를 저장함 
  		int result = mDao.userCheck(userid, pwd);
  		if(result == 1) {
  			MemberVO vo = mDao.getMember(userid); //로그인에 성공한 정보를 가져옴
  			HttpSession session = request.getSession(); 
  			session.setAttribute("loginUser", vo); //loginUser는 세션이라 브라우저 끄기 전까지 값이 기억됨
  			request.setAttribute("message", "회원가입에 성공했습니다."); //main에는 message가 없어서 상관없는거같긴한데 의미가 있나? 회원가입 성공메세지는 joinServlet에서도 띄워주는데...?
  			url = "member/main.jsp";
  			
  			//System.out.println("membervo : "+ vo); getMember에서 값이 출력되는지 확인
  			
  		}else if(result == 0) {
  			request.setAttribute("message", "비밀번호를 확인해주세요.");
  		}else if(result == -1) {
  			request.setAttribute("message", "아이디가 존재하지 않습니다.");
  		}
  		RequestDispatcher dis = request.getRequestDispatcher(url); //성공하면 url감
  		dis.forward(request, response);
  	}

}
