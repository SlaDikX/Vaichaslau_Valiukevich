package by.epam.training.builder;

import by.epam.training.entity.Wagon;
import by.epam.training.exception.WagonBuilderLogicalException;
import by.epam.training.parser.WagonDOMParser;
import by.epam.training.parser.WagonSAXParser;
import by.epam.training.parser.WagonStAXParser;

public class WagonBuilder {
	public static Wagon buildWagon(String parserName, String path)
			throws WagonBuilderLogicalException {
		Wagon wagon;
		switch (parserName) {
		case "SAX":
			WagonSAXParser sax = new WagonSAXParser();
			sax.parseDocument(path);
			wagon = sax.getWagon();
			break;
		case "DOM":
			WagonDOMParser dom = new WagonDOMParser();
			dom.parseDocument(path);
			wagon = dom.getWagon();
			break;
		case "STAX":
			WagonStAXParser stax = new WagonStAXParser();
			stax.parseDocument(path);
			wagon = stax.getWagon();
			break;
		default:
			wagon = null;
			throw new WagonBuilderLogicalException("Parser " + parserName
					+ " not exist");
		}
		return wagon;
	}
}
