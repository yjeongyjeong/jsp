package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//업로드를 get으로 하면 용량이 적어서 오류날수도 있음.. 따라서 업로드는 post로만!
@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String savePath = "upload";
		int uploadFileLimit = 5*1024*1024; //5MB
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		try {
			MultipartRequest multi = 
					new MultipartRequest(
							request,
							uploadFilePath,
							uploadFileLimit,
							encType,
							new DefaultFileRenamePolicy()
							);
			Enumeration files =  multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String)files.nextElement();
				System.out.println("file : " + file);
				
				String file_name = multi.getFilesystemName(file);
				System.out.println("file_name : " + file_name); //서버상 파일이름
				
				String ori_name = multi.getOriginalFileName(file); //실제 파일이름
				System.out.println("ori_name : " + ori_name);
				
				out.println("<br> 업로드 된 파일명 : " + file_name );
				out.println("<br> 원본 파일명 : " + ori_name );
				out.println("<hr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
