package com.saeyan.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt( request.getParameter("num") ) );
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO bDao =  BoardDAO.getInstance();
		int result = bDao.updateBoard(vo);
		
		if( result == 1) {
			response.sendRedirect("BoardServlet?command=board_list");
		}
	}

}
