package commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PageManager {
	
	// Read properties file
		public static String funcReadPropertiesFile(String fileProperties) {
			String strValue = null;
			//Properties prop = new Properties();
			//InputStream input = null;
			
			InputStream iStream = null;
			try {
				//read properties file in Unicode
				URL fileURL = new URL("file:" + fileProperties);
				iStream = fileURL.openStream();
				Reader reader = new BufferedReader(new InputStreamReader(iStream, StandardCharsets.UTF_8));
				Properties prop = new Properties();
				prop.load(reader);

				//input = new FileInputStream(fileProperties);
				//load a properties file
				//prop.load(input);

				for (String key : prop.stringPropertyNames()) {
					String val = prop.getProperty(key);
					System.setProperty(key, val);

					// System.out.println(key);
					// System.out.println(val);
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (iStream != null) {
					try {
						iStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return strValue;
		}

}
