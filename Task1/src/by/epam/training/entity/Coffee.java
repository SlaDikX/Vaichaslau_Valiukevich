package by.epam.training.entity;

import org.apache.log4j.Logger;

public class Coffee implements Comparable<Coffee>, Cloneable {
	static Logger logger = Logger.getLogger(Coffee.class);
	private String name;
	private int pricePerGram;
	private CoffeeState state;

	public Coffee(String name, int pricePerGram, CoffeeState state) {
		super();
		try {
			if (name == null) {
				throw new IllegalArgumentException("name");
			} else if (pricePerGram <= 0) {
				throw new IllegalArgumentException("pricePerGram");
			} else {
				this.name = name;
				this.pricePerGram = pricePerGram;
				this.state = state;
			}
		} catch (IllegalArgumentException e) {
			logger.error(e + " of making Coffee");
		}

	}

	public String getName() {
		return name;
	}

	public int getPricePerGram() {
		return pricePerGram;
	}

	public CoffeeState getState() {
		return state;
	}

	@Override
	public int compareTo(Coffee o) {
		return this.pricePerGram - o.getPricePerGram();
	}
}
