package org.com.mots.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.com.mots.util.FileUtil;

public class Main {

	/*
	 * File file = new File("/commons/io/project.properties"); List lines =
	 * FileUtils.readLines(file, "UTF-8");
	 */

	public static void main(String... args) {
		Main m = new Main();
		List<String> lines;
		LinkedList<String> words;

		Map<String, Integer> contagem = new HashMap<String, Integer>();

		/* 1) Ler arquivo de entrada */
		lines = m.readFile();

		/* 2) Separar as palavras */
		words = m.split(lines);

		/* 3) Efetuar logica de comparacao */
		for (String word : words) {
			if (contagem.containsKey(word)) {
				contagem.put(word, contagem.get(word) + 1);
			} else {
				contagem.put(word, 1);
			}
		}

		/* 3.1) colocando ordem no map */
		// Ordenar pelo value, quantidade de usos
//		contagem = FileUtil.sortByValue(contagem);

		// Ordenar pela palavra pra gente comparar as coisas
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(contagem);

		/* 4) Contabilizar ocorrencia das palavras */

		for (Entry<String, Integer> key : treeMap.entrySet()) {
			System.out.println("" + key.getKey() + " : " + key.getValue());
		}
	}

	public List<String> readFile() {
		try {
			File file = new File("D:/Cicero/GDrive/WorkSpace/EclipseProjects/compteur-mots/Arquivos/site_cinema.txt");
			return FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LinkedList<String> split(List<String> lines) {
		LinkedList<String> words = new LinkedList<String>();

		// Pattern pattern = Pattern.compile("\\ ");

		for (String currentLine : lines) {
			StringTokenizer tokenizer = new StringTokenizer(currentLine);

			while (tokenizer.hasMoreTokens()) {
				// retira pontos, de finais de frases
				words.add(FileUtil.retirarPontuacao(tokenizer.nextToken()));
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
