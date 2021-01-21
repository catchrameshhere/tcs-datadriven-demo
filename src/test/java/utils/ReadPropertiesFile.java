package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public Properties readFile(String fileName) {
		FileReader reader = null;
		Properties prop = null;
		try {
			reader=new FileReader(fileName);  

			prop=new Properties();  
			prop.load(reader); 
		}
		catch (FileNotFoundException e) {
			System.out.println("Specified file is not found");
		}
		catch (IOException e) {
			System.out.println("Unable to read the specified file");
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Could not close the property file properly because of the below mentioned reason");
				e.printStackTrace();
			}
		}
		
		return prop;
	}

}
