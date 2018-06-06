package pre.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pre.Factory.ServiceFactory;

/**
 * Servlet implementation class ReturnPictureUrl
 */
@WebServlet("/ReturnPictureUrl")
public class ReturnPictureUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnPictureUrl() {
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
		HttpSession session = request.getSession();
		List<Object> list= new ArrayList<Object>();				
		String cityName = request.getParameter("cityName");
		try{
			list = ServiceFactory.getWeatherServiceInstance().ListPicture(cityName);
		}catch(Exception e){
			e.printStackTrace();
		}
		session.setAttribute("cityurl", list.get(0));
		response.sendRedirect("/preWeather/html/index.jsp");
		
	}

}
