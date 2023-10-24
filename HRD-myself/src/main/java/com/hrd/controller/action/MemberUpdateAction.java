package com.hrd.controller.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.dto.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		MemberVO vo = new MemberVO();
		//1. 먼저 vo객체를 만들고 거기에다가 값을 집어넣어야 가져온 값이 저장됨
		
		//form에서 submit하면 value가 update니까 여기로 실행됨 따라서 입력한 값들을 받아서 저장시키면 됨
		vo.setCustno(Integer.parseInt(request.getParameter("custno")));
		vo.setCustname(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		vo.setJoindate(getTimestamp("joindate")); //timestamp 어케가져오냐
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		
		//2. DB와 연결해서 집어넣은 값이 존재하는 vo를 업데이트 쿼리시킴
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.updateMember(vo);
		
		System.out.println("result : " + result);
		if(result == 1 ) {
			response.sendRedirect("MemberServlet?command=member_list");
		}
	}
//일단 현재시간으로 들어가게 함...
	public Timestamp getTimestamp(String str){
		return Timestamp.valueOf(LocalDateTime.now());
	}

}
