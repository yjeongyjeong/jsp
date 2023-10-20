package com.saeyan.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		String url = "/board/boardView.jsp";
		String num = request.getParameter("num");
		//확인용
		System.out.println("num : " + request.getParameter("num"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = bDao.selectOneByNum(Integer.parseInt(num));
		
		request.setAttribute("board", vo);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		//list.jsp에서 forward방식으로 넘어갔기때문에 num값이 살아있음 redirect엿으면 없음 
		/*
		 * 리다이렉트 : response 객체의 sendRedirect()로 페이지를 이동하는 방법 브라우저의 url을 변경하도록하여 페이지를
		 * 이동하는 방식으로 request 와 response객체가 유지되지 않음 따라서 sendRedirect로 이동하려면 데이터를 전송하기 위해
		 * 파라미터 값을 이동할 페이지뒤에 쿼리 스트링 형태로 덧붙임 한글을 전송하려면 URLEncoder.encode()사용
		 * 
		 * 포워드 방식 : requestDispatcher객체로 접근하고 이동할 페이지를 지정함 또한 제어가 넘어간 특정 페이지의 url이 나타나지
		 * 않음 기존의 request객체가 유지되므로 이전 데이터를 전송하고 싶다면 request.setAttribute(“속성이름”,
		 * “속성값”);해주면 됨 이동한 페이지에서 쓰려면 getAttribute 한글을 전송하기위해 별도의 처리 없어도 됨
		 */	
		
	}

}
