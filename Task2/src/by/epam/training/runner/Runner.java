package by.epam.training.runner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import by.epam.training.entity.TextComponent;
import by.epam.training.loader.TextLoader;
import by.epam.training.logic.TextParser;
import by.epam.training.logic.TextSort;
import by.epam.training.logic.TextSwitch;

public class Runner {
	static Logger logger = Logger.getLogger(Runner.class);
	private static final String INPUT_FILE_PATH = "resourse\\Text.txt";
	private static final String OUTPUT_FILE_PATH = "resourse\\Out.txt";
	static {
		new DOMConfigurator().doConfigure("property\\log4j.xml",
				LogManager.getLoggerRepository());
	}

	public static void main(String[] args) {
		//read all text from file
		String s = TextLoader.getTextFromFile(INPUT_FILE_PATH);
		//parse received text
		TextComponent textComponent = TextParser.parseText(s);
		//switch words (1st word with last word )in sentences 
		TextSwitch.switchWord(textComponent);
		//Sorting sentences for the number of words in it
		TextSort.sortBySentenceSize(textComponent);
		//send processed text into a file
		TextLoader.putTextInFile(textComponent.getText(), OUTPUT_FILE_PATH);
	}
}
