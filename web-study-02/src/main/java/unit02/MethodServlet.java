package unit02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/method")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("id"); //"id" "age" => jsp에서 설정한 이름과 같아야 함
		String age= request.getParameter("age"); //쿼리스트링으로 처리되면 무조건 String이 되어서 int타입이 아님 int로 받고싶으면 형변환시키고 받으면 됨
		
		PrintWriter out = response.getWriter();
		out.println("<h1>get 방식으로 처리됨</h1>");
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "<br>");
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>post 방식으로 처리됨</h1>");
		
		out.close();
	}

}
