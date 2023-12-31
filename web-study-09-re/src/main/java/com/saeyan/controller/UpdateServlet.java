package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/memberUpdate.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
//		System.out.println(userid); //확인완료!
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO vo = mDao.getMember(userid);
		
		request.setAttribute("mVO", vo); //mVO라는 이름에 vo값을 넣어줌 참조변수
		
		System.out.println("mVO : " + vo );
		
		RequestDispatcher dis = request.getRequestDispatcher("member/update.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글깨짐
		//update.jsp 입력한 회원정보를 vo클래스에 저장
		MemberVO vo = new MemberVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email"));
		vo.setAdmin(Integer.parseInt( request.getParameter("admin")) );
		//웹에서 넘어오면 String이므로 int타입에 넣으려면 형변환이 필요함
		
//		DB연결(값을 전달함)
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.updateMember(vo); 
		System.out.println("vo : " + vo);
		System.out.println("result : " + result);
		
		if(result == 1) {
			request.setAttribute("message", "회원수정이 완료되었습니다.");
		} else {
			request.setAttribute("message", "회원수정에 실패하였습니다.");
		}
		
//		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
//		dis.forward(request, response);
		response.sendRedirect("login.do");
	}
}


