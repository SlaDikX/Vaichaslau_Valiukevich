package by.epam.training.entity;

public class Coffee {
	private String name;
	private int pricePerGram;

	public Coffee(String name, int pricePerGram) {
		super();
		this.name = name;
		this.pricePerGram = pricePerGram;
	}

	public String getName() {
		return name;
	}

	public int getPricePerGram() {
		return pricePerGram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pricePerGram;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffee other = (Coffee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pricePerGram != other.pricePerGram)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coffee [name=" + name + ", pricePerGram=" + pricePerGram + "]";
	}
}
