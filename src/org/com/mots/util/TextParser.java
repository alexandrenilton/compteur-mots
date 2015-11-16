package org.com.mots.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.cyberneko.html.parsers.DOMFragmentParser;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TextParser {

	StringBuffer TextBuffer = null;
	FileInputStream fin = null;
	InputSource inSource = null;

	public static InputStream returnInputStreamFromPage(String urlString) {
		URL url;
		InputStream is = null;

		try {
			url = new URL(urlString);
			URLConnection openConnection = url.openConnection();
			openConnection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			is = openConnection.getInputStream();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return is;
	}

	void processNode(Node node) {
		if (node == null)
			return;
		// Process a text node
		if (node.getNodeType() == Node.TEXT_NODE) {
			TextBuffer.append(node.getNodeValue());
		} else if (node.hasChildNodes()) {
			// Process the Node's children

			NodeList childList = node.getChildNodes();
			int childLen = childList.getLength();

			for (int count = 0; count < childLen; count++)
				processNode(childList.item(count));
		} else
			return;
	}// Extracts text from HTML Document

	String htmltoText(File file) {

		DOMFragmentParser parser = new DOMFragmentParser();

		File f = file;

		try {
			fin = new FileInputStream(f);
		} catch (Exception e) {
			System.out.println("Unable to open HTML file " + file.getName() + " for reading.");
			return null;
		}

		try {
			inSource = new InputSource(fin);
		} catch (Exception e) {
			System.out.println("Unable to open Input source from HTML file " + file.getName());
			return null;
		}

		CoreDocumentImpl codeDoc = new CoreDocumentImpl();
		DocumentFragment doc = codeDoc.createDocumentFragment();

		try {
			parser.parse(inSource, doc);
		} catch (Exception e) {
			System.out.println("Unable to parse HTML file " + file.getName());
			return null;
		}

		TextBuffer = new StringBuffer();

		// Node is a super interface of DocumentFragment, so no typecast needed
		processNode(doc);

		System.out.println("Done.");

		return TextBuffer.toString();
	}

	// Writes the parsed text from HTML to a file
	void writeTexttoFile(String htmlText, String fileName) {

		System.out.println("\nWriting HTML text to output text file " + fileName + "....");
		try {
			PrintWriter pw = new PrintWriter(fileName);
			pw.print(htmlText);
			pw.close();
		} catch (Exception e) {
			System.out.println("An exception occurred in writing the html text to file.");
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	// Extracts text from an HTML Document and writes it to a text file
	public static void main(String args[]) {

		String url = "https://www.immigration-quebec.gouv.qc.ca/fr/index.html";
		InputStream input = returnInputStreamFromPage(url);
		File tempFile = criarArquivoTemporario(input);

		TextParser htmlTextParserObj = new TextParser();
		String htmlToText = htmlTextParserObj.htmltoText(tempFile);

		if (htmlToText == null) {
			System.out.println("HTML to Text Conversion failed.");
		} else {
			System.out.println("\nThe text parsed from the HTML Document....\n" + htmlToText);
			htmlTextParserObj.writeTexttoFile(htmlToText, tempFile.getName());
		}
	}

	private static File criarArquivoTemporario(InputStream input) {
		File tempFile = new File("Teste.txt");
		try {
			FileOutputStream out = new FileOutputStream(tempFile);
			IOUtils.copy(input, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempFile;
	}
}
