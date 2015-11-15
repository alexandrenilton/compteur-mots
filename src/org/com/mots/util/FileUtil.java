package org.com.mots.util;

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
		word = word.replace("–", " ");
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
		word = word.replace(" ", "");
		word = word.replaceAll("\\p{Space}", "");
		word = word.replaceAll("\\d", " ");
		word = word.toLowerCase();
		return word;
	}

}
