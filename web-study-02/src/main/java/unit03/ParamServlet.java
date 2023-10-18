package unit03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>출력</h1>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age+ "<br>");
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		
		out.close();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //post전송할 때 한글깨짐 방지
		
		doGet(request, response); //일종의 forward : 아래 코드를 실행하는 대신 get이 받은 코드를 가져옴
		
		
		/*response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>출력</h1>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age+ "<br>");
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		
		out.close(); */
			}

}
