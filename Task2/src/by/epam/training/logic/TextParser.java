package by.epam.training.logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import by.epam.training.entity.TextComponent;
import by.epam.training.entity.TextComposite;
import by.epam.training.entity.TextLeaf;

public final class TextParser {
	static Logger logger = Logger.getLogger(TextParser.class);
	private static final String PROPERTY_PATH = "property\\regex.properties";
	static Properties property;
	static {
		property = new Properties();
		try {
			property.load(new FileInputStream(PROPERTY_PATH));
		} catch (IOException e) {
			logger.error("Can't find property file",e);
		}
	}

	public static TextComponent parseText(String text) {
		TextComponent mainTextComposite = new TextComposite();
		TextComponent childText;
		Pattern paragraph = Pattern.compile(property.getProperty("Paragraph"));
		Matcher matcherParagraph = paragraph.matcher(text);
		while (matcherParagraph.find()) {
			if (matcherParagraph.group().matches(
					property.getProperty("BlockCode"))) {
				childText = new TextLeaf();
				childText.setText(matcherParagraph.group());
			} else {
				childText = new TextComposite();
				childText.add(parseSentence(matcherParagraph.group()));
			}
			mainTextComposite.add(childText);
		}
		return mainTextComposite;
	}

	public static TextComponent parseSentence(String text) {
		TextComponent mainTextComposite = new TextComposite();
		Pattern sentence = Pattern.compile(property.getProperty("Sentence"));
		Matcher matcherSentence = sentence.matcher(text);
		while (matcherSentence.find()) {
			mainTextComposite.add(parseWord(matcherSentence.group()));
		}
		return mainTextComposite;
	}

	public static TextComponent parseWord(String text) {
		TextComponent mainTextComposite = new TextComposite();
		TextComponent childText;
		Pattern word = Pattern.compile(property.getProperty("Word"));
		Matcher matcherWord = word.matcher(text);
		while (matcherWord.find()) {
			childText = new TextLeaf();
			childText.setText(matcherWord.group());
			mainTextComposite.add(childText);
		}
		return mainTextComposite;
	}
}
