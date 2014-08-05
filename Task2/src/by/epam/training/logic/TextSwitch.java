package by.epam.training.logic;

import by.epam.training.entity.Document;

public class TextSwitch {
	public static void getSwitchedSentence(Document doc) {

		for (int i = 0; i < doc.getSizeOfChilds(); i++) {
			if (i + 1 == doc.getSizeOfChilds() - 1) {
				Document first, last;
				first = doc.getChild(0);
				last = doc.getChild(i);
				doc.getListOfChilds().set(0, last);
				doc.getListOfChilds().set(i, first);
			}
		}
	}

	public static void getSwitchedWord(Document doc) {
		for (int i = 0; i < doc.getSizeOfChilds(); i++) {
			getSwitchedSentence(doc.getChild(i));
		}
	}
}
