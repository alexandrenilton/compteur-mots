package org.com.mots.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTMLsUtils {
	
	public static void testeUrl() {
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;

		try {
			url = new URL("https://www.immigration-quebec.gouv.qc.ca/pt/biq/mexico/imigrar-trabalhar.html");
			URLConnection openConnection = url.openConnection();
			openConnection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			is = openConnection.getInputStream();
			// is = url.openStream(); // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
	}
}
