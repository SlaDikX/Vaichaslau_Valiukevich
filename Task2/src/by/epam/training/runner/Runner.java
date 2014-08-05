package by.epam.training.runner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import by.epam.training.entity.Document;
import by.epam.training.loader.FileLoader;
import by.epam.training.loader.TextReader;
import by.epam.training.logic.Parsing;
import by.epam.training.logic.TextFormatter;
import by.epam.training.logic.TextSwitch;

public class Runner {
	static {
		new DOMConfigurator().doConfigure(
				"src\\by\\epam\\training\\property\\log4j.xml",
				LogManager.getLoggerRepository());
	}
	static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
		String s = "";
		Properties pr = new Properties();
		FileLoader fileLoader = new FileLoader();
		BufferedReader br;
		try {
			br = fileLoader.open("src\\by\\epam\\training\\resourse\\Text.txt");
			s = TextReader.getTextFromStream(br);
			pr.load(new FileInputStream(
					"src\\by\\epam\\training\\property\\regex.properties"));
			// создаю объект состоящий из списка предложений и блоков кода
			Document mainText = Parsing.getSentence(s,
					pr.getProperty("BlockCodeAndSentence"));
			// разбиваю каждый элемен (предложение или блок кода) в mainText на
			// слова (части предложения )
			for (int i = 0; i < mainText.getSizeOfChilds(); i++) {
				Parsing.getWord(mainText.getChild(i).getName(),
						pr.getProperty("Word"), mainText.getChild(i));
			}
			// форматирую текс
			StringBuilder sb = new StringBuilder();
			TextFormatter.getFormatedText(mainText);
			TextSwitch.getSwitchedWord(mainText);
			TextFormatter.getFormatedText(mainText);
			for (int i = 0; i < mainText.getSizeOfChilds(); i++) {
				sb.append(mainText.getChild(i).getName());
			}
			br.close();
			// вывод данных в файл
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(
							"src\\by\\epam\\training\\resourse\\Out.txt")));
			out.write(sb.toString());
			out.close();
		} catch (NullPointerException e) {
			logger.error(e);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

	}
}
