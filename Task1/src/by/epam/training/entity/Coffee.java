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

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Coffee [name=");
		s.append(name);
		s.append(", pricePerGram=");
		s.append(pricePerGram);
		s.append(", state=");
		s.append(state);
		s.append("]");
		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pricePerGram;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		Coffee other = (Coffee) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pricePerGram != other.pricePerGram) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		return true;
	}

}
