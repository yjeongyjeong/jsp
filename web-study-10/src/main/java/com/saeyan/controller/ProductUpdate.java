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

@WebServlet("/productUpdate.do")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String code = request.getParameter("code");  //productList.jsp에서 code=${product.code}로 코드값을 넘겨줌
 		System.out.println("code : " + code);
 		//코드값으로 vo를 불러와서 수정할 수 있게 함->값을 request에 담아서 forward시켜줌
 		//post가 받아서 값을 업데이트
 		
 		ProductDAO pDao = ProductDAO.getInstance(); //객체 생성한게 아니라 생성된 객체를 참조함
 		ProductVO vo =  pDao.selectProductByCode(code);//여기서 select~~~ 메서드에 의해 객체 생성되면서 ProductVO vo를 받아오는데 여기서 vo에 다시 담아줌
 		
 		request.setAttribute("product", vo); //리퀘스트영역에 product라는 객체가 생기고 vo를 참조함 => 즉 selectProductByCode로 인해 만들어진 vo(code값에 의해 db에서 vo형태로 값을 담아온 상태)가 여기서 만들어진 vo로 참조되고 그 주소를 참조중 ===> jsp에서 vo객체를 참조중임
 		
 		RequestDispatcher dis = request.getRequestDispatcher("product/productUpdate.jsp");
 		dis.forward(request, response);
 	}

 	//productUpdate.jsp에서 submit
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureurl = multi.getParameter("pictureurl");
		
		if(pictureurl == null) {
			pictureurl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO vo = new ProductVO();
		vo.setCode(Integer.parseInt(code));
		vo.setName(name);
		vo.setPrice(price);
		vo.setDescription(description);
		vo.setPictureurl(pictureurl);
/*		System.out.println("name : " + name);
		System.out.println("vo : " + vo);
		System.out.println("실제경로 : "+ path);
*/	
		ProductDAO pDao = ProductDAO.getInstance();
		int result = pDao.updateProduct(vo); //1이면 값 넣기 성공 0이면 실패
		System.out.println("result : " + result );
		
		if(result == 1) {
			response.sendRedirect("productList.do");
		} else {
			response.sendRedirect("productWrite.do");
		}
	}
		
		
		
}


