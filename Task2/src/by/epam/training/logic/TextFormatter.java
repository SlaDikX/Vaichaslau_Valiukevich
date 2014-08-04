package by.epam.training.logic;

import by.epam.training.entity.Document;

public class TextFormatter {

	public static Document getFormatedSentence(Document doc) {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < doc.getSizeOfChilds(); i++) {
			if ((i + 1 < doc.getSizeOfChilds())
					&& (doc.getChild(i + 1).getName().contains(",")
							|| doc.getChild(i + 1).getName().contains("!")
							|| doc.getChild(i + 1).getName().contains("»")
							|| doc.getChild(i + 1).getName().contains(".")
							|| doc.getChild(i + 1).getName().contains(")")
							|| doc.getChild(i + 1).getName().contains("?")
							|| doc.getChild(i + 1).getName().contains(";")
							|| doc.getChild(i + 1).getName().contains("'") || doc
							.getChild(i + 1).getName().contains(":"))) {
				s.append(doc.getChild(i).getName());
			} else if (doc.getChild(i).getName().contains("«")
					|| doc.getChild(i).getName().contains("(")
					|| doc.getChild(i).getName().contains("'")
					|| doc.getChild(i).getName().contains(".")

					|| doc.getChild(i).getName().contains("\n")) {
				s.append(doc.getChild(i).getName());

			} else {
				s.append(doc.getChild(i).getName());
				s.append(" ");
			}
		}
		doc.setName(s.toString());
		return doc;
	}

	public static Document getFormatedText(Document doc) {
		for (int i = 0; i < doc.getSizeOfChilds(); i++) {
			getFormatedSentence(doc.getChild(i));
		}
		return doc;
	}
}