package com.saeyan.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		RequestDispatcher dis = request.getRequestDispatcher("/board/boardCheckPass.jsp"); //여러군데를 거치는데 계속 forward방식으로 넘겨주고 있기 때문에 num값이 jsp까지 쭉~~ 날아감
		dis.forward(request, response); 
/*
 * 정리합시다... 
 * 먼저 view에서 (view 서블릿에서 num으로 vo타입 가져오는데 이 값을 board라는 이름에 참조)게시글 수정을 누르게되면 쿼리스트링을 통해 num와 커맨드 값이 넘어감
 * 그럼 서블렛으로 가서 커맨드 값을 확인하게 되는데 액션 팩토리로 인해서 BoardCheckPassFormAction()의 객체를 만들게 됨! 따라서 서블릿에서 action이 null값이 아니게 되니까
 * execute가 실행되는데 여기서 action.execute는 바로 위에 오버라이드 된 내용이 실행되게 됨
 * 따라서 forward값으로 jsp에 값을 넘겨주게 됨->값이 살아있음
 * 
 * 
 * => action에 따라서 어떤 방식으로 값을 넘길지 결정됨(action execute)는 액션팩토리에서 객체를 만드는 곳에 따라 다른 값을 오버라이딩하게 되기 때문에...!!
 */
	}

}
