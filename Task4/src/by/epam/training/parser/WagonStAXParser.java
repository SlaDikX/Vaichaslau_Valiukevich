package by.epam.training.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import by.epam.training.builder.CoffeeBuilder;
import by.epam.training.entity.Bag;
import by.epam.training.entity.Bank;
import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;
import by.epam.training.entity.Container;
import by.epam.training.entity.Wagon;

public class WagonStAXParser {
	static Logger logger = Logger.getLogger(WagonStAXParser.class);
	private XMLInputFactory inputFactory;
	private Wagon wagon;
	private Container container;
	private String coffeeState;
	private String coffeName;
	private int coffePricePerGram = 0;
	private int containerVolume = 0;
	private CoffeeState state = null;
	private Coffee coffee;

	public WagonStAXParser() {
		inputFactory = XMLInputFactory.newInstance();
	}

	public void parseDocument(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();

				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if ("wagon".equals(name)) {
						int wagonCapacity = 0;
						int wagonPrice = 0;
						wagonCapacity = Integer.parseInt(reader
								.getAttributeValue(0));
						wagonPrice = Integer.parseInt(reader
								.getAttributeValue(1));
						wagon = new Wagon(wagonCapacity, wagonPrice);
					} else if ("coffee".equals(name)) {
						coffeeState = reader.getAttributeValue(0).toUpperCase();
						if ("BEAN".equals(coffeeState)) {
							state = CoffeeState.BEAN;
						} else if ("MILLED".equals(coffeeState)) {
							state = CoffeeState.MILLED;
						} else if ("INSTANTE".equals(coffeeState)) {
							state = CoffeeState.INSTANTE;
						}
					} else if ("name".equals(name)) {
						coffeName = reader.getElementText();
					} else if ("price-per-gram".equals(name)) {
						coffePricePerGram = Integer.parseInt(reader
								.getElementText());
					} else if ("volume".equals(name)) {
						containerVolume = Integer.parseInt(reader
								.getElementText());
					}
				} else if (type == XMLStreamConstants.END_ELEMENT) {
					name = reader.getLocalName();
					if ("coffee".equals(name)) {
						coffee = CoffeeBuilder.buildCoffee(coffeName,
								coffePricePerGram, state);
						state = null;
						coffePricePerGram = 0;
					}
					if ("bag".equals(name)) {
						container = new Bag(containerVolume, coffee);
						wagon.addContainer(container);
					} else if ("bank".equals(name)) {
						container = new Bank(containerVolume, coffee);
						wagon.addContainer(container);
					}
				}
			}
		} catch (XMLStreamException ex) {
			logger.error("StAX parsing error! ", ex);
		} catch (FileNotFoundException ex) {
			logger.error("File " + fileName + " not found! ", ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error("Impossible close file " + fileName + ": ", e);
			}
		}
	}

	public Wagon getWagon() {
		return wagon;
	}
}