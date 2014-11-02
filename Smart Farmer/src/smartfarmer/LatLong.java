package smartfarmer;
import java.util.ArrayList;
import java.util.StringTokenizer;

import smartfarmer.model.Point;

public class LatLong {
	public static Point getPoint(String St[] , String dis ){
		Point p = new Point(0,0);
		for( int i = 0 ;  i < 64 ; i++ ){
			if( St[i].startsWith(dis) ){
				String my[] = Split(St[i] , " " ); 
				p = new Point( Double.parseDouble( my[1] ) , Double.parseDouble( my[2] ) ) ;
				
				break ;
			}
		}
		return p ;
	}
	public static String[] Split(String x, String tkn) {
        StringTokenizer StrTkn = new StringTokenizer(x, tkn);
        ArrayList<String> ArrLis = new ArrayList<String>(x.length());
        while (StrTkn.hasMoreTokens()) ArrLis.add(StrTkn.nextToken());
        return ArrLis.toArray(new String[0]);
	}
}
