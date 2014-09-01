package by.epam.training.parser;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.epam.training.entity.Wagon;

public class WagonSAXParser {
	static Logger logger = Logger.getLogger(WagonSAXParser.class);
	private WagonHandler handler;

	public void parseDocument(String fileName) {

		XMLReader reader;
		try {
			reader = XMLReaderFactory.createXMLReader();
			handler = new WagonHandler();
			reader.setContentHandler(handler);
			reader.parse(fileName);
		} catch (SAXException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public Wagon getWagon() {
		return handler.getWagon();
	}
}