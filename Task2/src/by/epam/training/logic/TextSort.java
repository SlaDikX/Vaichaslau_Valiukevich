package by.epam.training.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam.training.entity.TextComponent;
import by.epam.training.entity.TextComposite;

public final class TextSort {

	public static void sortBySentenceSize(TextComponent textComponent) {
		List<TextComponent> sortList;
		for (int i = 0; i < textComponent.getChildren().size(); i++) {
			if (textComponent.getChild(i) instanceof TextComposite) {
				for (int j = 0; j < textComponent.getChild(i).getChildren()
						.size(); j++) {
					sortList = new ArrayList<TextComponent>();
					sortList.addAll(textComponent.getChild(i).getChild(j)
							.getChildren());
					Collections.sort(sortList);
					textComponent.getChild(i).getChild(j).setChildren(sortList);
				}
			}
		}
	}
}
