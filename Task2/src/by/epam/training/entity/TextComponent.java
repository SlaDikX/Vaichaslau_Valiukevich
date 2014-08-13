package by.epam.training.entity;

import java.util.List;

public abstract class TextComponent implements Comparable<TextComponent> {

	public void add(TextComponent textComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(TextComponent textComponent) {
		throw new UnsupportedOperationException();
	}

	public TextComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	public String getText() {
		throw new UnsupportedOperationException();
	}

	public void setText(String text) {
		throw new UnsupportedOperationException();
	}

	public List<TextComponent> getChildren() {
		throw new UnsupportedOperationException();
	}

	public void setChildren(List<TextComponent> textComponents) {
		throw new UnsupportedOperationException();
	}

}
