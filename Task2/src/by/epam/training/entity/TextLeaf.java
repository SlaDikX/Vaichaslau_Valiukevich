package by.epam.training.entity;

public class TextLeaf extends TextComponent {

	private String text;

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int compareTo(TextComponent o) {
		return text.length() - o.getText().length();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		TextLeaf other = (TextLeaf) obj;
		if (text == null) {
			{
				if (other.text != null) {
					return false;
				}
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TextLeaf [text=" + text + "]";
	}

}
