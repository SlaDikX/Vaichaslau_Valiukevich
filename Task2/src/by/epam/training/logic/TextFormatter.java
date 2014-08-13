package by.epam.training.logic;

public final class TextFormatter {

	public static boolean isPunctuationAfterWord(String textComponent) {
		if ((",".equals(textComponent) || "»".equals(textComponent)
				|| ".".equals(textComponent) || ")".equals(textComponent)
				|| "?".equals(textComponent) || ";".equals(textComponent)
				|| ":".equals(textComponent) || "!".equals(textComponent))) {
			return true;
		}
		return false;
	}

	public static boolean isPunctuationBeforeWord(String textComponent) {
		if (("«".equals(textComponent) || "(".equals(textComponent))
				) {
			return true;
		}
		return false;
	}
}
