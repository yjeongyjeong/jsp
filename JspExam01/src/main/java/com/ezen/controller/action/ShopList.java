package com.ezen.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopDAO;
import com.ezen.dto.MemberVO;

public class ShopList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		ShopDAO sDao = ShopDAO.getInstance();
		List<MemberVO> lists = sDao.shopList();
		
		request.setAttribute("lists", lists);
		for(MemberVO mlist : lists)
			System.out.println(mlist);
		
		//값가지고 넘어감
		RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
		dis.forward(request, response);
	}

}
