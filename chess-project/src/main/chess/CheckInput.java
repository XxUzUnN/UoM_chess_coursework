package chess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
	
	public static boolean checkCoordinateValidity(String input){
		Pattern validpattern = Pattern.compile("[0-7]['a'-'i']");
		Matcher validmatcher = validpattern.matcher(input);
		if (validmatcher.matches()){
			return true;
		}
		else{
			return false;
		}
	}
}
