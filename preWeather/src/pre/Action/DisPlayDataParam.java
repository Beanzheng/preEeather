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
 * Servlet implementation class DisPlayDataParam
 */
@WebServlet("/DisPlayDataParam")
public class DisPlayDataParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisPlayDataParam() {
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
		List<Object> list = new ArrayList<>();
		try {
			list = ServiceFactory.getWeatherServiceInstance().getTimeCityWeather();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("city", list.get(0));
		session.setAttribute("temp", list.get(1));
		
		session.setAttribute("city2", list.get(2));
		session.setAttribute("temp2", list.get(3));
		
		session.setAttribute("city3", list.get(4));
		session.setAttribute("temp3", list.get(5));
		
		session.setAttribute("city4", list.get(6));
		session.setAttribute("temp4", list.get(7));
		
		session.setAttribute("city5", list.get(8));
		session.setAttribute("temp5", list.get(9));
		
		session.setAttribute("city6", list.get(10));
		session.setAttribute("temp6", list.get(11));
		
		response.sendRedirect("/preWeather/html/index.jsp");
	}

}