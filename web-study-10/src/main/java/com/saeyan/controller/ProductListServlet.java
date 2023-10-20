package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productList.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductVO> productList = pDao.selectAllProduct();
		//궁금증.. list안에는 vo형태로 보관이 되어있는건가? 아니면 key, value값으로 여러개가 있는건가..?
		
		/*
		 * for(ProductVO vo : productList) //잘 받아왓는지 출력해봄 System.out.println(vo);
		 */
		
		request.setAttribute("productList", productList);
		RequestDispatcher dis = request.getRequestDispatcher("product/productList.jsp");
		dis.forward(request, response);
	}

	
	/*
	 * 		ProductDAO pDao = ProductDAO.getInstance(); //객체 생성해서
		List<ProductVO> productList = pDao.selectAllProduct(); //list형태로 정보 받아오고
		request.setAttribute("productList", productList); // get방식으로 요청을 처리할 때... productList라는 이름으로 배열받아줌
		
		for(ProductVO vo : productList) //잘 받아왓는지 출력해봄
			System.out.println(vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("product/productList.jsp");
		dis.forward(request, response);
//		requestdispatcher : 클라이언트로부터 받은 요청들을 정의하고 서블렛이나 html, jsp 등의 소스를 서버로 보내줌 => 요청에 따라 "~~~.jsp"로 연결시켜줌 (살짝 요청받고 요청대로 처리해주는 느낌?)
//		그리고 forward방식으로 보내줌? (서블렛에서 받은 요청을 따라 다른데로 연결시켜줌)
//		값담은걸 보내줌
	 * 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
