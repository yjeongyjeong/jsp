package com.hrd.controller.action;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.dto.MemberVO;

public class MemberJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		/*  회원번호(자동발행)	
			회원성명	
			회원전화	
			회원주소	
			가입일자	
			고객등급	
			도시코드
		 */
		String url = "MemberServlet?command=member_list";

		MemberVO vo = new MemberVO();
		
		//vo.setCustno(Integer.parseInt(request.getParameter("custno")) );
		vo.setCustname(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		vo.setJoindate(Timestamp.valueOf(LocalDateTime.now()));
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		System.out.println("join에서 받은 vo : " + vo);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.joinMember(vo); 
		System.out.println("joinaction에서 나온 result : " + result);
		
		if(result == 1) {
			response.sendRedirect(url); //왜 리다이렉트?
		}
	}

}
