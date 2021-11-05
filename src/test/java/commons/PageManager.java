package commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PageManager {
	String[] readexcel = new String[1000];

	// Read properties file
	public static String funcReadPropertiesFile(String fileProperties) {
		String strValue = null;
		// Properties prop = new Properties();
		// InputStream input = null;

		InputStream iStream = null;
		try {
			// read properties file in Unicode
			URL fileURL = new URL("file:" + fileProperties);
			iStream = fileURL.openStream();
			Reader reader = new BufferedReader(new InputStreamReader(iStream, StandardCharsets.UTF_8));
			Properties prop = new Properties();
			prop.load(reader);

			// input = new FileInputStream(fileProperties);
			// load a properties file
			// prop.load(input);

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

//		function Read and Write excel file.
//	tai file rar "https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-5.1.0-20211024.zip"
//	vi maven khong co library cua XSSFWorkbook
	public String[] readExcelFileReturnArray(String filePath, String fileName, String SheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			guru99Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet guru99Sheet = guru99Workbook.getSheet(SheetName);
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum() + 1;
		int count_readexcel = 1;
		for (int i = 0; i < rowCount; i++) {
			Row row = guru99Sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
//				System.out.print(row.getCell(j).getStringCellValue() + "|| ");
				readexcel[count_readexcel] = row.getCell(j).getStringCellValue();
				count_readexcel = count_readexcel + 1;
			}
		}
		return readexcel;
	}
}