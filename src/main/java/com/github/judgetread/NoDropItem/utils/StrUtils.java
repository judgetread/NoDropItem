package main.java.com.github.judgetread.NoDropItem.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;

public class StrUtils {
	public static String colorize(String str) {
		return str == null ? str : ChatColor.translateAlternateColorCodes('&', str);
	}

	public static String unicodize(String str) {
		return str == null ? str : StringEscapeUtils.unescapeJava(str);
	}

	public static String convertText(String str) {
		str = colorize(str);
		str = unicodize(str);
		return str;
	}

	public static ArrayList<String> convertText(ArrayList<String> stringList) {
		ArrayList<String> convertedList = new ArrayList<String>();
		for (String str : stringList) {
			String newString = colorize(str);
			newString = unicodize(newString);
			convertedList.add(newString);
		}
		return convertedList;
	}

	public static List<String> convertText(List<String> stringList) {
		List<String> convertedList = new ArrayList<String>();
		for (String str : stringList) {
			String newString = colorize(str);
			newString = unicodize(newString);
			convertedList.add(newString);
		}
		return convertedList;
	}

}
