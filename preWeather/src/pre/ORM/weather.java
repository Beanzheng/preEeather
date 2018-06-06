package pre.ORM;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class weather {
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCityTime() {
		return cityTime;
	}
	public void setCityTime(int cityTime) {
		this.cityTime = cityTime;
	}
	public String getCityTemp() {
		return cityTemp;
	}
	public void setCityTemp(String cityTemp) {
		this.cityTemp = cityTemp;
	}
	@JsonIgnore
	public int getWid() {
		return wid;
	}
	@JsonIgnore
	public void setWid(int wid) {
		this.wid = wid;
	}
	private int wid;
	private String cityName;
	private int cityTime;
	private String cityTemp;
}
