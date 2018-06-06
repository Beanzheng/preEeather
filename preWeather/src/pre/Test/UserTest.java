package pre.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.api.model.ParameterBinding.Kind;

import pre.DAO.UserDAO;
import pre.DAO.WeatherDAO;
import pre.DAOImpl.UserDAOImpl;
import pre.DAOImpl.WeatherDAOImpl;
import pre.DB.DBConection;
import pre.ORM.weather;
import pre.ORM.xts;
import pre.Service.WeatherService;
import pre.ServiceImpl.WeatherServiceImpl;

public class UserTest {
	private static DBConection db = new DBConection();
	private static Connection conn = null;
	private static UserDAO dao = null;
	private static WeatherDAO wdao = null;
	private static xts ts =null;
	private static weather wea = null;
	private static WeatherService service = null;
	@BeforeClass
	public static void beforeclass() throws Exception{
		conn =db.getConn();
		dao = new UserDAOImpl(conn);
		wdao = new WeatherDAOImpl(conn);
		ts = new xts();
		wea = new weather();
		service = new WeatherServiceImpl();
		
	}
	/**
	 * �������ݿ�����
	 */
	@Test
	public void TestDB() throws Exception{
		String sql = "select * from user";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			System.out.println("����ͨ��");
		}else {
			System.out.println("����ʧ��");
		}
	}
	/**
	 * �����û�ע��
	 * @throws Exception
	 */
	@Test
	public void TestUserDAO_resigter() throws Exception{
		String userName = "asaadw";
		String password = "123";
		String sex = "��";
		Assert.assertTrue(dao.resigter(userName, password, sex));
		
	}
	/**
	 * �����û���¼
	 * @throws Exception
	 */
	@Test
	public void TestUserDAO_login() throws Exception{
		String userName = "asaadw";
		String password = "123";
		Assert.assertTrue(dao.login(userName, password));
	}
	@Test
	public void TestWeatherDAO_getWeatherDetail() throws Exception{
		String cityName= "������";
		List<Object> list = wdao.getWeatherDetail(cityName);
		for(Object i: list ){
			System.out.println(i);
		}
	}
	@Test
	public void TestWeatherDAO_getXTSDetail() throws Exception{
		List<Object> list = wdao.getXTSDeatail();
//		for(Object i: list ){
//			System.out.println(i);
//		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	@Test
	public void TestWeatherDAO_getTimeCityWeather() throws Exception{
		String cityName = "������";
		int cityTime = 7;
		List<Object> list = wdao.getTimeCityWeather();
		for(Object i: list ){
			System.out.println(i);
		}
	}
	@Test
	public void TestTurnJson() throws Exception{
		List<Object> list = wdao.getXTSDeatail();
		ts.setCityName((String)list.get(0));
		ts.setTitle((String)list.get(1));
		ts.setContent((String)list.get(2));
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ts);
		System.out.println(json);
	}
	@Test
	public void TurnWeatherDetail() throws Exception{
		String cityName = "������";
		List<Object> list = wdao.getWeatherDetail(cityName);
		wea.setCityName((String)list.get(0));
		wea.setCityTime((int)list.get(1));
		wea.setCityTemp((String)list.get(2));
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(wea);
		System.out.println(json);
		
	}
	@Test
	public void TurnCityDetail() throws Exception{
		String cityName = "������";
		int cityTime = 7;
		List<Object> list = wdao.getTimeCityWeather();
		for(Object i : list){
			System.out.println(i);
		}
	}
	@Test
	public void Test_Search() throws Exception{
		String cityName = "������";
		List<Object> list = service.Search(cityName);
		for(Object i : list){
			System.out.println(i);
		}
	}
	@Test
	public void Test_url() throws Exception{
		String cityName ="China";
		List<Object> list = service.ListPicture(cityName);
		for(Object i : list){
			System.out.println(i);
		}
	}
	@AfterClass
	public static void afterclass() throws Exception{
		
	}
}