package by.epam.training.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.epam.training.entity.Document;
import by.epam.training.entity.Sentence;
import by.epam.training.entity.Text;
import by.epam.training.entity.Word;

public class Parsing {
	public static Document getSentence(String text, String regex) {
		Document mainText = new Text();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			Document sentence = new Sentence();
			sentence.setName(matcher.group());
			mainText.add(sentence);
		}
		return mainText;
	}

	public static Document getWord(String text, String regex, Document sen) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			Document word = new Word();
			word.setName(matcher.group());
			sen.add(word);
		}
		return sen;
	}
}
