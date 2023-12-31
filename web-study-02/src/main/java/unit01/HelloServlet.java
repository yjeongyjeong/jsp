package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("INIT!"); //서버 시작할 때 최초 한 번
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DOGET"); //새로고침마다..
		response.setContentType("text/html; charset=utf-8"); //맨위에다 기입!! 중간에 기입하면 오류날수도있음
		//html문서대로 응답하겠다는 의미, utf-8을 사용하겠다는 의미 => 한글깨짐 방지 
		
		PrintWriter out = response.getWriter();
		
		out.println("Hello Servlet");
		out.println("안녕하신가"); //한글 깨짐
		
	}



	@Override
	public void destroy() {
		System.out.println("DESTROY"); //서버 끝낼때
	}
}
