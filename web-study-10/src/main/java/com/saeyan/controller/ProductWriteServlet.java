package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("product/productWriter.jsp");
		dis.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품수정페이지에서 제출시 작동되는 코드
		request.setCharacterEncoding("utf-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		int sizeLimit = 20*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = 
				new MultipartRequest(
						request,
						path,
						sizeLimit,
						encType,
						new DefaultFileRenamePolicy()
						);
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		
		String pictureurl = multi.getFilesystemName("pictureurl");
		
		ProductVO vo = new ProductVO();
		vo.setName(name);
		vo.setPrice(price);
		vo.setDescription(description);
		vo.setPictureurl(pictureurl);
		System.out.println("name : " + name);
		System.out.println("vo : " + vo);
		System.out.println("실제경로 : "+ path);
		
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.insertProduct(vo); //1이면 값 넣기 성공 0이면 실패
		System.out.println("result : " + result );
		
		if(result == 1) {
			response.sendRedirect("productList.do");
		} else {
			response.sendRedirect("productWrite.do");
		}
	}
}
