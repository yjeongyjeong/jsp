package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String savePath = "upload"; //다운받을 경로(저장되는 곳 폴더이름)
		int uploadFileSize = 5*1024*1024; //5MB까지로 제한
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리");
		System.out.println(context.getRealPath(savePath));
		
		try {
			MultipartRequest multi 
			= new MultipartRequest(
					request, //MultipartRequest와 연결할 request 객체
					uploadFilePath, //서버상 실제 파일 저장 경로
					uploadFileSize, //파일 제한 크기 (5MB)
					encType, //인코딩
					new DefaultFileRenamePolicy() //중복처리를 위한 매개변수 ->파일중복시 파일명 뒤에 숫자첨부
					);
			//서버 저장된 파일명(실제 파일명과 상이할 수 잇음)
			String fileName = multi.getFilesystemName("uploadFile") ;
			if(fileName == null) { //업로드 실패
				System.out.println("파일업로드... 실패....");
			}else { //업로드 성공
				out.println("<br> 작성자 : " + multi.getParameter("name")); //jsp에서 읽어옴
				out.println("<br> 제목 : " + multi.getParameter("title")); //jsp에서 읽어옴
				out.println("<br> 파일명 : " + fileName); 
				out.println("<br> 실제 파일명 : " + multi.getOriginalFileName("uploadFile")); //jsp에서 읽어옴
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
