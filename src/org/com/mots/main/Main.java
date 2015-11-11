package org.com.mots.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Main {

	/*
	 * File file = new File("/commons/io/project.properties"); List lines =
	 * FileUtils.readLines(file, "UTF-8");
	 */

	public static void main(String... args) {
		Main m = new Main();
		List<String> lines;
		LinkedList<String> words;

		/* 1) Ler arquivo de entrada */
		lines = m.readFile();

		/* 2) Separar as palavras */
		words = m.split(lines);

		/* 3) Efetuar logica de comparacao */
		
		/* 4) Contabilizar ocorrencia das palavras */ 
	}

	public List<String> readFile() {
		try {
			File file = new File(
					"C:\\Users\\notebook\\git\\compteur-mots\\texto_simple.txt");
			return FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LinkedList<String> split(List<String> lines) {
		LinkedList<String> words = new LinkedList<String>();

		Pattern pattern = Pattern.compile("\\w+");

		for (String currentLine : lines) {
			Matcher matcher = pattern.matcher(currentLine);
			while (matcher.find()) {
				words.add(matcher.group());
			}
		}
		return words;
	}

	/* Exemplo leitura html */

	/*
	 * InputStream in; try { in = new
	 * URL("http://commons.apache.org").openStream();
	 * 
	 * InputStreamReader inR = new InputStreamReader(in); BufferedReader buf =
	 * new BufferedReader(inR); String line; while ((line = buf.readLine()) !=
	 * null) { System.out.println(line); }
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

}
