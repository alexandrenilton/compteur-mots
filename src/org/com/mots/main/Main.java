package org.com.mots.main;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.com.mots.util.FileUtil;
import org.com.mots.util.HTMLsUtils;

public class Main {

	/*
	 * File file = new File("/commons/io/project.properties"); List lines =
	 * FileUtils.readLines(file, "UTF-8");
	 */
	/*
	 * public static void main(String... args) { List<String> lines;
	 * LinkedList<String> words;
	 * 
	 * Map<String, Integer> contagem = new HashMap<String, Integer>();
	 * 
	 * // 1) Ler arquivo de entrada lines = readFile();
	 * 
	 * // 2) Separar as palavras words = split(lines);
	 * 
	 * // 3) Efetuar logica de comparacao contarPalavras(words, contagem);
	 * 
	 * // 3.1) colocando ordem no map // Ordenar pelo value, quantidade de usos
	 * contagem = FileUtil.sortByValue(contagem);
	 * 
	 * // Ordenar pela palavra pra gente comparar as coisas // Map<String,
	 * Integer> treeMap = new TreeMap<String, // Integer>(contagem);
	 * 
	 * // 4) Contabilizar ocorrencia das palavras
	 * 
	 * for (Entry<String, Integer> key : contagem.entrySet()) {
	 * System.out.println("" + key.getKey() + " : " + key.getValue()); } }
	 */
	
	public static void main(String... args) {
		HTMLsUtils.testeUrl();
	}

	public static void contarPalavras(LinkedList<String> words, Map<String, Integer> contagem) {
		for (String word : words) {
			if (contagem.containsKey(word)) {
				contagem.put(word, contagem.get(word) + 1);
			} else {
				contagem.put(word, 1);
			}
		}
	}

	public static List<String> readFile() {
		try {
			File file = new File("D:/Cicero/GDrive/WorkSpace/EclipseProjects/compteur-mots/Arquivos/site_cinema.txt");
			return FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static LinkedList<String> split(List<String> lines) {
		LinkedList<String> words = new LinkedList<String>();

		for (String currentLine : lines) {
			StringTokenizer tokenizer = new StringTokenizer(currentLine);
			while (tokenizer.hasMoreTokens()) {
				// retira pontos, de finais de frases
				words.add(FileUtil.retirarPontuacao(tokenizer.nextToken()));
			}
		}
		return words;
	}
}
