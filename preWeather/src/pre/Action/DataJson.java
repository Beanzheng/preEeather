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

import com.fasterxml.jackson.databind.ObjectMapper;

import pre.Factory.DAOFactory;
import pre.Factory.ServiceFactory;
import pre.ORM.xts;

/**
 * Servlet implementation class DataJson
 */
@WebServlet("/DataJson")
public class DataJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataJson() {
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
			list = ServiceFactory.getWeatherServiceInstance().getXTSDetail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		xts ts = new xts();
//		ts.setCityName((String)list.get(0));
//		ts.setTitle((String)list.get(1));
//		ts.setContent((String)list.get(2));
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(ts);
//		System.out.print(json);
//		session.setAttribute("json",json);
		session.setAttribute("title", list.get(0));
		session.setAttribute("content", list.get(1));
		
		session.setAttribute("title2", list.get(2));
		session.setAttribute("content2", list.get(3));
		
		session.setAttribute("title3", list.get(4));
		session.setAttribute("content3", list.get(5));
		
		session.setAttribute("title4", list.get(6));
		session.setAttribute("content4", list.get(7));
		
		session.setAttribute("title5", list.get(8));
		session.setAttribute("content5", list.get(9));
		
		session.setAttribute("title6", list.get(10));
		session.setAttribute("content6", list.get(11));
		
		session.setAttribute("title7", list.get(12));
		session.setAttribute("content7", list.get(13));
		response.sendRedirect("/preWeather/html/index.jsp");;
	}

}
