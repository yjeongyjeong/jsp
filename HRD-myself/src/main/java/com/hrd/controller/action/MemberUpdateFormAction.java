package com.hrd.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.dto.MemberVO;

public class MemberUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/member/memberUpdate.jsp";
		String custno = request.getParameter("custno");
		
		System.out.println("custno : " + custno);

		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO vo = mDao.selectOneByCustno(custno);
		System.out.println("vo : " + vo);
		
		request.setAttribute("member", vo);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
