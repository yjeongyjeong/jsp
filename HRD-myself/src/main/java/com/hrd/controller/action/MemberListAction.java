package com.hrd.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.dto.MemberVO;

public class MemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/member/memberList.jsp";
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberVO> memberList = mDao.selectAllMembers();
		
		for(MemberVO vv : memberList)
			System.out.println(vv);
		
		request.setAttribute("memberList", memberList);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
