package by.epam.training.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import by.epam.training.logic.TextFormatter;

public class TextComposite extends TextComponent {
	private List<TextComponent> textComponentList = new ArrayList<TextComponent>();

	@Override
	public void add(TextComponent textComponent) {
		textComponentList.add(textComponent);
	}

	@Override
	public void remove(TextComponent textComponent) {
		textComponentList.remove(textComponent);
	}

	@Override
	public TextComponent getChild(int i) {
		return textComponentList.get(i);
	}

	@Override
	public List<TextComponent> getChildren() {
		return Collections.unmodifiableList(textComponentList);
	}

	@Override
	public void setChildren(List<TextComponent> textComponents) {
		textComponentList=textComponents;
	}

	@Override
	public String getText() {
		StringBuilder s = new StringBuilder();
		ListIterator<TextComponent> textComponetIterator = textComponentList
				.listIterator();
		while (textComponetIterator.hasNext()) {
			TextComponent textComponent = textComponetIterator.next();
			s.append(textComponent.getText());
			if (textComponetIterator.hasNext()) {
				TextComponent textComponentChild = textComponetIterator.next();
				if (!TextFormatter.isPunctuationAfterWord(textComponentChild
						.getText())
						&& !TextFormatter.isPunctuationBeforeWord(textComponent
								.getText())) {
					s.append(" ");
				}
				textComponetIterator.previous();
			}
		}
		return s.toString();
	}

	@Override
	public int compareTo(TextComponent o) {
		return textComponentList.size() - o.getChildren().size();
	}
}
