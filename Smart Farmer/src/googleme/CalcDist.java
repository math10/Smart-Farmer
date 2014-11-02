package googleme;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcDist {
		
	public static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
	      double theta = lon1 - lon2;
	      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	      dist = Math.acos(dist);
	      dist = rad2deg(dist);
	      dist = dist * 60 * 1.1515;
	      if (unit == 'K') {
	        dist = dist * 1.609344;
	      } else if (unit == 'N') {
	        dist = dist * 0.8684;
	        }
	      dist = round(dist,2);
	      return dist;
	    }

	     static double deg2rad(double deg) {
	      return (deg * Math.PI / 180.0);
	    }

	     static double rad2deg(double rad) {
	      return (rad * 180.0 / Math.PI);
	    }
	     public static double round(double value, int places) {
	    	    if (places < 0) throw new IllegalArgumentException();

	    	    BigDecimal bd = new BigDecimal(value);
	    	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    	    return bd.doubleValue();
	    	}
}
