package com.trello.qsp.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readTheDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resource/data.properties");
        Properties pobj = new Properties(); //constructor overloading
        pobj.load(fis);  //method overloading
        String value = pobj.getProperty(key);
        return value;
	}

}
