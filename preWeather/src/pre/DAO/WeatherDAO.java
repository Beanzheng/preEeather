package pre.DAO;

import java.util.List;

/**
 * ����Ԥ�����ݵײ��߼�
 * @author shineion
 *
 */
public interface WeatherDAO {
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
	public List<Object> getXTSDeatail() throws Exception;
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
	public List<Object> search(String cityName) throws Exception;
	/**
	 * 
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public List<Object> ListPicture(String cityName) throws Exception;
}