package com.ezen.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopDAO;

public class ShopListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "shop/shopList.jsp";
		
		ShopDAO sDao = ShopDAO.getInstance();
		
	}

}
