package pre.Service;
import java.util.List;
/**
 * 业务逻辑接口
 * @author shineion
 *
 */
public interface WeatherService {
	/**
	 * 
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public List<Object> getWeatherDetail(String cityName) throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Object> getXTSDetail() throws Exception;
	/**
	 * 
	 * @param cityName
	 * @param cityTime
	 * @return
	 * @throws Exception
	 */
	public List<Object> getTimeCityWeather() throws Exception;
	/**
	 * 
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public List<Object> Search(String cityName) throws Exception;
	/**
	 * 
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public List<Object> ListPicture(String cityName) throws Exception;
}
