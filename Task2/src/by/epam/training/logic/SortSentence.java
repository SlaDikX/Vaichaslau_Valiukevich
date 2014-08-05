package by.epam.training.logic;

import java.util.Collections;

import by.epam.training.entity.Document;

public class SortSentence {
	public static void getSortedTextBySentence(Document doc) {
		Collections.sort(doc.getListOfChilds());
	}
}
