package pre.ORM;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class xts {
	@JsonIgnore
	public int getTid() {
		return tid;
	}
	@JsonIgnore
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private int tid;
	private String cityName;
	private String title;
	private String content;
}
