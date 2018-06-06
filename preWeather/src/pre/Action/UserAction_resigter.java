package pre.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import pre.Factory.ServiceFactory;

/**
 * Servlet implementation class UserAction_resigter
 */
@WebServlet("/UserAction_resigter")
public class UserAction_resigter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction_resigter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		try{
			userName=request.getParameter("userName");
			password=request.getParameter("password");
			sex =request.getParameter("sex");
			System.out.print("�û���:"+userName+"����:"+password+"�Ա�:"+sex);
			if(ServiceFactory.getUserServiceInstace().resigter(userName, password, sex)){
					printWriter.print("<a href='/preWeather/html/frontweb/web/login.html'>ע��ɹ��������¼</a>");
//					response.sendRedirect("/preWeather/html/login.html");
			}else {
					printWriter.print("<a href='/preWeather/html/register.html'>ע��ʧ�ܣ��������ע��</a>");
			}
		}catch(Exception e){
			printWriter.print("<a href='/preWeather/html/frontweb/web/register.html'>ע��ʧ�ܣ��������ע��</a>");
			e.printStackTrace();
		}			
		
	}

}
