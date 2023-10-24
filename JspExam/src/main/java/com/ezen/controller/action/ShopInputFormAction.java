package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopDAO;

public class ShopInputFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		ShopDAO sDao = ShopDAO.getInstance();
		int custNo = sDao.getSelectCustNo();
		
		System.out.println("custNo : " + custNo );
		request.setAttribute("custNo", (custNo+1));
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("input.jsp");
		dis.forward(request, response);

	}

}
