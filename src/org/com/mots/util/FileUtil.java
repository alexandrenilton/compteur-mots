package org.com.mots.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileUtil {

	public static String retirarPontuacao(String word) {
		// word = word.replace("[^']&&\\p{P}", " ");
		word = word.replace("}", " ");
		word = word.replace("|", " ");
		word = word.replace("{", " ");
		word = word.replace("`", " ");
		word = word.replace("_", " ");
		word = word.replace("_", " ");
		word = word.replace("^", " ");
		word = word.replace("]", " ");
		word = word.replace("\\", " ");
		word = word.replace("[", " ");
		word = word.replace("@", " ");
		word = word.replace("?", " ");
		word = word.replace(">", " ");
		word = word.replace("=", " ");
		word = word.replace("<", " ");
		word = word.replace(";", " ");
		word = word.replace(":", " ");
		word = word.replace("/", " ");
		word = word.replace(".", " ");
		word = word.replace("-", " ");
		word = word.replace(",", " ");
		word = word.replace("+", " ");
		word = word.replace("*", " ");
		word = word.replace(")", " ");
		word = word.replace("(", " ");
		word = word.replace("&", " ");
		word = word.replace("%", " ");
		word = word.replace("$", " ");
		word = word.replace("#", " ");
		word = word.replace("\"", " ");
		word = word.replace("–", " ");
		word = word.replaceAll("\\d", " ");
		word = word.replaceAll(" ", "");
		word = word.replaceAll("\\p{Space}", "");
		word = word.toLowerCase();
		return word;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
