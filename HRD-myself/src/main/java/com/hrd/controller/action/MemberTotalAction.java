package com.hrd.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.dto.MemberVO;

public class MemberTotalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "member/memberTotal.jsp";
		
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberVO> memberList = mDao.selectPriceMember();
		
		for(MemberVO vo : memberList)
			System.out.println(vo); //나오지도않음 
		
		request.setAttribute("memberList", memberList);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
