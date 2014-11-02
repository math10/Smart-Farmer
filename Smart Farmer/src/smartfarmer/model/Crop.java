package smartfarmer.model;

public class Crop {

	public Crop(int id, String name, String cultivation, String temparature,
			String weather, String place) {
		super();
		this.id = id;
		this.name = name;
		this.cultivation = cultivation;
		this.temparature = temparature;
		this.weather = weather;
		this.place = place;
	}
	public Crop(){
		
	}

	private int id;
	private String name;
	private String cultivation;
	private String temparature;
	private String weather;
	private String place;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCultivation() {
		return cultivation;
	}

	public void setCultivation(String cultivation) {
		this.cultivation = cultivation;
	}

	public String getTemparature() {
		return temparature;
	}

	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
