import java.util.*;

//Class all the constant information for the numerical representation of the board
public class boardInfo {
	
	//What each number represents in terms of active component
	public static Map<Integer, String> getNumberLegend(){
		Map<Integer, String> legend = new HashMap<Integer, String>();
		
		
		return legend;
	}
	
	public static Map<String, Integer> getAvailableColors(){
		Map<String, Integer> colors = new HashMap<String, Integer>();
		
		int hexaCode = 000;
		colors.put("Red", hexaCode);
		return colors;
	}
}
