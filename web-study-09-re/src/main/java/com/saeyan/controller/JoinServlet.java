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

//입력한게 서블릿의 get으로 가고 jsp로 감
//jsp에서 서블릿의 post로 가고 브라우저로 감
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("member/join.jsp"); //requestdispatcher : 클라이언트로부터 요청을 수신하고 이를 서버의 리소스(예: 서블릿, HTML 파일 또는 JSP 파일)로 보내는 개체를 정의..RequestDispatcher 는 페이지 호출 없이 jsp 파일 내에서 다른 파일로 요청을 보내고 바로 응답을 받는것이고, sendRedirect 는 브라우저가 response에 따라 서버로 지정된 경로를 다시 요청하여 페이지를 호출한다
		dis.forward(request, response);
	}

	//회원가입에서 입력한 값들 받아오기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글깨짐
		//join.jsp 입력한 회원정보를 vo클래스에 저장
		MemberVO vo = new MemberVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email"));
		vo.setAdmin(Integer.parseInt( request.getParameter("admin")) );
		//웹에서 넘어오면 String이므로 int타입에 넣으려면 형변환이 필요함
//		System.out.println("vo : " + vo); 확인
		
//		DB연결(값을 전달함)
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(vo); //근데 이걸 정수값으로 받을 필요가 있나? 나중에 오류나면 출력하려고 받는건가? => if(result ==1)로 받아서 회원가입 성공 실패여부 출력하네 나올 수 있는 경우의 수는 1(성공시 result값이 1이됨), 0(함수 실행은 되었는데 값넣기 실패하면 0), -1(아예 함수도 안돌면 -1)
		
		if(result == 1) {
			request.setAttribute("message", "회원가입에 성공했습니다..");
		} else {
			request.setAttribute("message", "회원가입에 실패했습니다...");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		dis.forward(request, response);
	}

}
