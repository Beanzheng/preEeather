package pre.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pre.DAO.WeatherDAO;

public class WeatherDAOImpl extends AbstractDAOImpl implements WeatherDAO{

	public WeatherDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public List<Object> getWeatherDetail(String cityName) throws Exception {
		List list1=new ArrayList();
		String sql = "select cityName,cityTime,cityTemp from temprature where cityName=?";
		super.pstm = super.conn.prepareStatement(sql);
		super.pstm.setString(1, cityName);
		ResultSet rs = super.pstm.executeQuery();
		while(rs.next()){
			for(int i =1;i < 4; i++){
				list1.add(rs.getObject(i));
			}
		}
		return list1;
	}

	@Override
	public List<Object> getXTSDeatail() throws Exception {
		List<Object> list2 = new ArrayList<Object>();
		String sql = "select title,content from xts";
		super.pstm = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstm.executeQuery();
		while(rs.next()){
			for(int i = 1;i<3;i++){
				list2.add(rs.getObject(i));
			}
		}
		return list2;
	}

	@Override
	public List<Object> getTimeCityWeather() throws Exception {
		String sql = "select cityName,cityTemp from temprature where cityTime=7";
		List<Object> list3 = new ArrayList<Object>();
		super.pstm = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstm.executeQuery();
		while(rs.next()){
			for(int i=1;i< 3; i++){
				list3.add(rs.getObject(i));
			}
		}
		return list3;
	}

	@Override
	public List<Object> search(String cityName) throws Exception {
		String sql = "select cityName,cityTime,cityTemp from temprature where cityName=?";
		List<Object> list4 = new ArrayList<Object>();
		super.pstm = super.conn.prepareStatement(sql);
		super.pstm.setString(1, cityName);
		ResultSet rs = super.pstm.executeQuery();
		while(rs.next()){
			for(int i=1;i<4 ;i++){
				list4.add(rs.getObject(i));
			}
		}
		return list4;
	}

	@Override
	public List<Object> ListPicture(String cityName) throws Exception {
		String sql = "select cityPicture from city where cityName=?";
		List<Object> list5 = new ArrayList<Object>();
		super.pstm = super.conn.prepareStatement(sql);
		super.pstm.setString(1, cityName);
		ResultSet rs = super.pstm.executeQuery();
		while(rs.next()){
			for(int i= 1;i<2;i++){
				list5.add(rs.getObject(i));
			}
		}
		return list5;
	}

}
