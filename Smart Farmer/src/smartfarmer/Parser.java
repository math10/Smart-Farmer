package smartfarmer;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parser {
	static double [] parse( String st[] , String dis ){
		double D[] = new double[207];
		for( int i = 0 ; i < 64 ; i++ ){
			if( st[i].startsWith(dis) ){
				String my[] = Split( st[i] , " " );
				int len = my.length;
				for( int k = 1 ; k < len ; k++ ){
					D[k-1] = Double.parseDouble( my[k] );
				}
				break ;
			}
		}
		return D ;
	}
	public static String[] Split(String x, String tkn) {
        StringTokenizer StrTkn = new StringTokenizer(x, tkn);
        ArrayList<String> ArrLis = new ArrayList<String>(x.length());
        while (StrTkn.hasMoreTokens()) ArrLis.add(StrTkn.nextToken());
        return ArrLis.toArray(new String[0]);
	}
}