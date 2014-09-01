package by.epam.training.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import by.epam.training.builder.CoffeeBuilder;
import by.epam.training.entity.Bag;
import by.epam.training.entity.Bank;
import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;
import by.epam.training.entity.Container;
import by.epam.training.entity.Wagon;

public class WagonDOMParser {
	static Logger logger = Logger.getLogger(WagonDOMParser.class);
	private DocumentBuilder docBuilder;
	private Wagon wagon;
	private Container container;
	private String coffeeState;
	private String coffeName;
	private int coffePricePerGram = 0;
	private int containerVolume = 0;
	private CoffeeState state = null;
	private Coffee coffee;
	private String containerName;

	public WagonDOMParser() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			logger.error("Parser configuration error: ", e);
		}
	}

	public void parseDocument(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			if (doc.hasChildNodes()) {
				fillElements(doc.getChildNodes());
			}
		} catch (IOException e) {
			logger.error("File error or I/O error: ", e);
		} catch (SAXException e) {
			logger.error("Parsing failure: ", e);
		}
	}

	private void fillElements(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node tempNode = nodeList.item(i);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				if ("wagon".equals(tempNode.getNodeName())) {
					int wagonCapacity = 0;
					int wagonPrice = 0;
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						if ("capacity".equals(node.getNodeName())) {
							wagonCapacity = Integer.parseInt(node
									.getNodeValue());
						} else if ("total-price".equals(node.getNodeName())) {
							wagonPrice = Integer.parseInt(node.getNodeValue());
						}
					}
					wagon = new Wagon(wagonCapacity, wagonPrice);

				} else if ("bag".equals(tempNode.getNodeName())) {
					containerName = "bag";

				} else if ("bank".equals(tempNode.getNodeName())) {
					containerName = "bank";

				} else if ("coffee".equals(tempNode.getNodeName())) {
					NamedNodeMap nodeMap = tempNode.getAttributes();
					coffeeState = nodeMap.item(0).getNodeValue().toUpperCase();
					if ("BEAN".equals(coffeeState)) {
						state = CoffeeState.BEAN;
					} else if ("MILLED".equals(coffeeState)) {
						state = CoffeeState.MILLED;
					} else if ("INSTANTE".equals(coffeeState)) {
						state = CoffeeState.INSTANTE;
					}

				} else if ("name".equals(tempNode.getNodeName())) {
					coffeName = tempNode.getTextContent();

				} else if ("price-per-gram".equals(tempNode.getNodeName())) {
					coffePricePerGram = Integer.parseInt(tempNode
							.getTextContent());

				} else if ("volume".equals(tempNode.getNodeName())) {
					containerVolume = Integer.parseInt(tempNode
							.getTextContent());
				}

				if (coffeName != null && coffePricePerGram != 0
						&& state != null) {
					coffee = CoffeeBuilder.buildCoffee(coffeName,
							coffePricePerGram, state);
					coffeName = null;
					state = null;
					coffePricePerGram = 0;
				}
				if ("bag".equals(containerName) && containerVolume != 0
						&& coffee != null) {
					container = new Bag(containerVolume, coffee);
					coffee = null;
					containerVolume = 0;
					wagon.addContainer(container);
				} else if ("bank".equals(containerName) && containerVolume != 0
						&& coffee != null) {
					container = new Bank(containerVolume, coffee);
					coffee = null;
					containerVolume = 0;
					wagon.addContainer(container);
				}
				if (tempNode.hasChildNodes()) {
					fillElements(tempNode.getChildNodes());
				}
			}

		}
	}

	public Wagon getWagon() {
		return wagon;
	}
}