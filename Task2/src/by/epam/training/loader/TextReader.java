package by.epam.training.loader;

import java.io.BufferedReader;
import java.io.IOException;

public class TextReader {
 public static String getTextFromStream(BufferedReader br) throws IOException{
	 StringBuilder s = new StringBuilder();
	 String str;
	 while((str = br.readLine())!= null)
	 {
		 s.append(str);
		 s.append('\n'); }
	 
	 return s.toString();
 }
}
