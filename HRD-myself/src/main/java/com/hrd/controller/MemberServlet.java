package com.hrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.controller.action.Action;
import com.hrd.controller.action.ActionFactory;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String command = request.getParameter("command");
 		System.out.println("요청을 받은 것을 확인 : " + command);
 		
 		ActionFactory af = ActionFactory.getInstance();
 		Action action = af.getAction(command);
 		
 		if( action != null) {
 			try {
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
 		}
 	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
