package by.epam.training.entity;

public abstract class Container implements Comparable<Container>, Cloneable {
	
	public abstract int getVolume();

	public abstract void setVolume(int volume);

	public abstract Coffee getCoffee();

	public abstract void setCoffee(Coffee coffee);

	public abstract int getPrice();

	public abstract int getWeight();

	public int getRelationPriceToWeight() {
		return getPrice() / getWeight();
	}
	public abstract String getContainerType();
	@Override
	public int compareTo(Container o) {
		return this.getRelationPriceToWeight() - o.getRelationPriceToWeight();
	}

}
