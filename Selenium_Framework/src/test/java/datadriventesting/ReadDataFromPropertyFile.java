package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resource/vtigerdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String applnUrl = pobj.getProperty("url");
		System.out.println("Application url: "+applnUrl);
	}
}
