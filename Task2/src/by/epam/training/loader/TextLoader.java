package by.epam.training.loader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.log4j.Logger;

public class TextLoader {
	static Logger logger = Logger.getLogger(TextLoader.class);

	public static String getTextFromFile(String filePath) {
		BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader(filePath));
			StringBuilder s = new StringBuilder();
			String str;
			while ((str = bReader.readLine()) != null) {
				s.append(str);
				s.append('\n');
			}
			return s.toString();
		} catch (FileNotFoundException e) {
			logger.error(e);
			return null;
		} catch (IOException e) {
			logger.error(e);
			return null;
		} finally {
			try {
				bReader.close();
			} catch (IOException e) {
				logger.error("Can't close BufferedReader Stream ", e);

			}
		}
	}

	public static void putTextInFile(String text, String filePath) {
		BufferedWriter bWriter = null;
		try {
			bWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath)));
			bWriter.write(text);
		} catch (NullPointerException e) {
			logger.error(e);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				bWriter.close();
			} catch (IOException e) {
				logger.error("Can't close BufferedWriter Stream", e);
			}
		}
	}
}
