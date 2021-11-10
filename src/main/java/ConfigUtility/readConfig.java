package ConfigUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	static Properties pro;

	public static String Config(File src,String key){
		
		String data = "";
	try {

			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();

			pro.load(fis);

			data =  pro.getProperty(key);

	}
	
	catch (Exception e) {
		System.out.println("Exception is :"+e.getMessage());
	}
	return data;
	

	}

}
