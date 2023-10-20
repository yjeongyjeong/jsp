package com.saeyan.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		//boardWrite.jsp에서 입력된 값들을 받아오기 위해 vo생성, 값담아주고 dao에 있는 메서드 실행
		BoardVO vo = new BoardVO();
		
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		int result = bDao.insertBoard(vo);
		//메서드가 잘 실행된다면(DB에 추가가 잘 된다면) 
		if(result == 1) {
			response.sendRedirect("BoardServlet?command=board_list");
		}
		
		
	}

	/*
	 * 리다이렉트 : response 객체의 sendRedirect()로 페이지를 이동하는 방법
	브라우저의 url을 변경하도록하여 페이지를 이동하는 방식으로 request 와 response객체가 유지되지 않음
	따라서 sendRedirect로 이동하려면 데이터를 전송하기 위해 파라미터 값을 이동할 페이지뒤에 쿼리 스트링 형태로 덧붙임
	한글을 전송하려면 URLEncoder.encode()사용
	
	포워드 방식 : requestDispatcher객체로 접근하고 이동할 페이지를 지정함
	또한 제어가 넘어간 특정 페이지의 url이 나타나지 않음
	기존의 request객체가 유지되므로 이전 데이터를 전송하고 싶다면 request.setAttribute(“속성이름”, “속성값”);해주면 됨 이동한 페이지에서 쓰려면 getAttribute
	한글을 전송하기위해 별도의 처리 없어도 됨
	 * 
	 * */
}
