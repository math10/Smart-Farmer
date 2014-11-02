package smartfarmer.model;

public class Point {

	public Point(double latiTude, double longiTude) {
		super();
		this.LatiTude = latiTude;
		this.LongiTude = longiTude;
	}
	Point(){
		
	}
	private double LatiTude ;
	private double LongiTude ;
	
	public double getLatiTude() {
		return LatiTude;
	}
	public void setLatiTude(double latiTude) {
		this.LatiTude = latiTude;
	}
	public double getLongiTude() {
		return LongiTude;
	}
	public void setLongiTude(double longiTude) {
		this.LongiTude = longiTude;
	}
}
