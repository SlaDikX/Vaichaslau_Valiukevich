package by.epam.training.logic;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.entity.TextComponent;
import by.epam.training.entity.TextComposite;

public final class TextSwitch {
	public static void switchSentence(TextComponent textComponent) {
		List<TextComponent> switchList;
		for (int i = 0; i < textComponent.getChildren().size(); i++) {
			if (i + 1 == textComponent.getChildren().size() - 1) {
				switchList = new ArrayList<TextComponent>();
				switchList.addAll(textComponent.getChildren());
				TextComponent first, last;
				first = textComponent.getChild(0);
				last = textComponent.getChild(i);
				switchList.set(0, last);
				switchList.set(i, first);
				textComponent.setChildren(switchList);
			}
		}
	}

	public static void switchWord(TextComponent textComponent) {
		for (int i = 0; i < textComponent.getChildren().size(); i++) {
			if (textComponent.getChild(i) instanceof TextComposite) {
				for (int j = 0; j < textComponent.getChild(i).getChildren()
						.size(); j++) {
					for (int y = 0; y < textComponent.getChild(i)
							.getChild(j).getChildren().size(); y++) {
						if (textComponent.getChild(i).getChild(j)
								.getChild(y) instanceof TextComposite) {
							switchSentence(textComponent.getChild(i)
									.getChild(j).getChild(y));
						}
					}
				}
			}
		}
	}
}
