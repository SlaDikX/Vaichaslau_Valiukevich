package by.epam.training.parser;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.training.builder.CoffeeBuilder;
import by.epam.training.entity.Bag;
import by.epam.training.entity.Bank;
import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;
import by.epam.training.entity.Container;
import by.epam.training.entity.Wagon;

public class WagonHandler extends DefaultHandler {
	final static Logger logger = Logger.getLogger(WagonHandler.class);
	private Wagon wagon;
	private Container container;
	private String coffeeState;
	private String coffeName;
	private int coffePricePerGram;
	private int containerVolume;
	private String temp;
	private CoffeeState state;
	private Coffee coffee;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		if ("wagon".equals(localName)) {
			int capacity = 0;
			int wagonPrice = 0;
			for (int i = 0; i < attributes.getLength(); i++) {
				if ("capacity".equals(attributes.getLocalName(i))) {
					capacity = Integer.parseInt(attributes.getValue(i));
				} else if ("total-price".equals(attributes.getLocalName(i))) {
					wagonPrice = Integer.parseInt(attributes.getValue(i));
				}
			}
			wagon = new Wagon(capacity, wagonPrice);
		} else if ("coffee".equals(localName)) {
			coffeeState = attributes.getValue(0).toUpperCase();
			if ("BEAN".equals(coffeeState)) {
				state = CoffeeState.BEAN;
			} else if ("MILLED".equals(coffeeState)) {
				state = CoffeeState.MILLED;
			} else if ("INSTANTE".equals(coffeeState)) {
				state = CoffeeState.INSTANTE;
			}
		} else if ("name".equals(localName)
				|| "price-per-gram".equals(localName)
				|| "volume".equals(localName)) {
			temp = localName;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String s = new String(ch, start, length).trim();
		if ("name".equals(temp)) {
			coffeName = s;
			temp = "";
		} else if ("price-per-gram".equals(temp) && s != "") {
			coffePricePerGram = Integer.parseInt(s);
			temp = "";
		} else if ("volume".equals(temp) && s != "") {
			containerVolume = Integer.parseInt(s);
			temp = "";
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if ("coffee".equals(localName)) {
			coffee = CoffeeBuilder.buildCoffee(coffeName, coffePricePerGram,
					state);
		} else if ("bag".equals(localName)) {
			container = new Bag(containerVolume, coffee);
			wagon.addContainer(container);
		} else if ("bank".equals(localName)) {
			container = new Bank(containerVolume, coffee);
			wagon.addContainer(container);
		}
	}

	public Wagon getWagon() {
		return wagon;
	}

}
