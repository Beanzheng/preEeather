package pre.ServiceImpl;

import java.sql.Connection;
import java.util.List;

import pre.DB.DBConection;
import pre.Factory.DAOFactory;
import pre.Service.WeatherService;

public class WeatherServiceImpl implements WeatherService{
	private DBConection dbc=  new DBConection();
	@Override
	public List<Object> getWeatherDetail(String cityName) throws Exception {
		return DAOFactory.getWeatherDaoInstance((Connection)
				this.dbc.getConn()).getWeatherDetail(cityName);
	}

	@Override
	public List<Object> getXTSDetail() throws Exception {
		return DAOFactory.getWeatherDaoInstance((Connection)
				this.dbc.getConn()).getXTSDeatail();
	}

	@Override
	public List<Object> getTimeCityWeather() throws Exception {
		return DAOFactory.getWeatherDaoInstance((Connection)
				this.dbc.getConn()).getTimeCityWeather();
	}

	@Override
	public List<Object> Search(String cityName) throws Exception {
		// TODO Auto-generated method stub
		return DAOFactory.getWeatherDaoInstance((Connection)
				this.dbc.getConn()).search(cityName);
	}

	@Override
	public List<Object> ListPicture(String cityName) throws Exception {
		return DAOFactory.getWeatherDaoInstance((Connection)
				this.dbc.getConn()).ListPicture(cityName);
	}

}
