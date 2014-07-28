package by.epam.training.entity;

import java.io.Serializable;
import by.epam.training.calculation.PriceCalculation;
import by.epam.training.calculation.WeightCalculation;

public abstract class Package implements Comparable<Package>, Serializable,
		Cloneable {

	private static final long serialVersionUID = 2554644111176157416L;
	private int volume = 0;
	private Coffee coffee;
	private CoffeeState coffeeState;

	public CoffeeState getCoffeeState() {
		return coffeeState;
	}

	public Package(int volume, Coffee coffee, CoffeeState coffeeState) {
		super();
		this.volume = volume;
		this.coffee = coffee;
		this.coffeeState = coffeeState;
	}

	public int getVolume() {
		return volume;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public int getWeight() {
		return WeightCalculation.calculateWeight(getVolume(), getCoffeeState());
	}

	public int getPrice() {
		return PriceCalculation.calculatePrice(getWeight(), getCoffee()
				.getPricePerGram());
	}

	public int getRelationPriceToWeight() {
		return getPrice() / getWeight();
	}

	@Override
	public int compareTo(Package o) {
		return this.getRelationPriceToWeight() - o.getRelationPriceToWeight();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(Package.this.getClass()
				.getSimpleName()
				+ " [volume="
				+ volume
				+ ", Coffee Name="
				+ coffee.getName()
				+ ", Coffee State="
				+ coffeeState
				+ "  Density="
				+ coffeeState.getDensity()
				+ ", Weight="
				+ getWeight()
				+ ", Price Per Gram="
				+ coffee.getPricePerGram()
				+ ", Price="
				+ getPrice()
				+ ", RalationPtW="
				+ getRelationPriceToWeight() + "]");
		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffee == null) ? 0 : coffee.hashCode());
		result = prime * result
				+ ((coffeeState == null) ? 0 : coffeeState.hashCode());
		result = prime * result + volume;
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
		Package other = (Package) obj;
		if (coffee == null) {
			if (other.coffee != null)
				return false;
		} else if (!coffee.equals(other.coffee))
			return false;
		if (coffeeState != other.coffeeState)
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}

}
