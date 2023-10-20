package com.saeyan.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/board/boardUpdate.jsp";
		
		String num = request.getParameter("num");
		//확인용
		System.out.println("num : " + request.getParameter("num"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = bDao.selectOneByNum(Integer.parseInt(num));
		
		request.setAttribute("board", vo);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
