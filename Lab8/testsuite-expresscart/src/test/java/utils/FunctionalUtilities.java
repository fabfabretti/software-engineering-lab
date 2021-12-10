package utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionalUtilities {

	public static float convertPriceToFloat(String price) {
		price = price.replaceFirst("�", "");
		return Float.parseFloat(price.trim());
	}
	
	public static String getRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@test.it";

    }
	
	public static float extractPriceFromString(String s) {
		Pattern p = Pattern.compile("[0-9]+,[0-9]*");
		Matcher m = p.matcher(s);
		m.find();
		return Float.parseFloat(m.group(0).replace(',', '.'));
    }

}
 