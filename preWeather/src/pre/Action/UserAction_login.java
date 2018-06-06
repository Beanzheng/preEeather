package pre.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pre.Factory.ServiceFactory;

/**
 * Servlet implementation class UserAction_login
 */
@WebServlet("/UserAction_login")
public class UserAction_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String userName = null;
		String password = null;
		try{
			userName=request.getParameter("userName");
			password=request.getParameter("password");
			System.out.print("用户名:"+userName+"密码:"+password);
			if(ServiceFactory.getUserServiceInstace().login(userName, password)){
					response.sendRedirect("/preWeather/html/index.jsp");
			}else {
					printWriter.println("<a href='/preWeather/html/frontweb/web/login.html'>登录失败，点击重新登录</a>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}			
	}

}
