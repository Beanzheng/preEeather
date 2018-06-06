package pre.Factory;

import pre.Service.UserService;
import pre.Service.WeatherService;
import pre.ServiceImpl.UserServiceImpl;
import pre.ServiceImpl.WeatherServiceImpl;

public class ServiceFactory {
	public static UserService getUserServiceInstace() {
		return new UserServiceImpl();
	}
	public static WeatherService getWeatherServiceInstance(){
		return new WeatherServiceImpl();
		
	}
}
