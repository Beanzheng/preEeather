package pre.Factory;

import java.sql.Connection;

import pre.DAO.UserDAO;
import pre.DAO.WeatherDAO;
import pre.DAOImpl.UserDAOImpl;
import pre.DAOImpl.WeatherDAOImpl;

public class DAOFactory {
	public static UserDAO getUserDaoInstance(Connection conn){
		return new UserDAOImpl(conn);
	}
	public static WeatherDAO getWeatherDaoInstance(Connection conn){
		return new WeatherDAOImpl(conn);
		
	}
}
