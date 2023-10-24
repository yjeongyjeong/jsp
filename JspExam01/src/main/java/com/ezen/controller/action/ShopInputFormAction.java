package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopDAO;

import oracle.net.aso.s;

public class ShopInputFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "input.jsp";
		
		ShopDAO sDao = ShopDAO.getInstance();
		int custno = sDao.getSelectCustNo();
		request.setAttribute("custno", custno + 1); //마지막번호 +1
		//이렇게 받아야 시퀀스번호 받은 컬럼이 없어져도 숫자가 안끊김
		//시퀀스로 받으면 증가는 하는데 중간에 컬럼 삭제하면 숫자 구멍생김ㅜㅜ
		
		System.out.println("custno : " + (custno + 1));
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
