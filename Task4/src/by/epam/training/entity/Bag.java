package by.epam.training.entity;

import org.apache.log4j.Logger;

import by.epam.training.calculation.Calculation;
import by.epam.training.exception.ContainerLogicalException;

public class Bag extends Container {
	static Logger logger = Logger.getLogger(Bag.class);
	private int volume;
	private Coffee coffee;

	public Bag(int volume, Coffee coffee) {
		try {
			if (volume <= 0) {
				throw new ContainerLogicalException("Volume");
			} else {
				this.volume = volume;
				this.coffee = coffee;
			}
		} catch (ContainerLogicalException e) {
			logger.error(e + " of making Bank");
		}
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;

	}

	@Override
	public Coffee getCoffee() {
		return coffee;
	}

	@Override
	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;

	}

	@Override
	public int getWeight() {
		return volume * getCoffee().getState().getDensity();
	}

	@Override
	public int getPrice() {
		return Calculation.calculatePrice(getWeight(), getCoffee()
				.getPricePerGram());
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Bag [Volume=");
		s.append(getVolume());
		s.append(", Coffee=");
		s.append(getCoffee().getName());
		s.append(", CoffeeState=");
		s.append(getCoffee().getState());
		s.append(", Price=");
		s.append(getPrice());
		s.append(", Weight=");
		s.append(getWeight());
		s.append(", RelationPriceToWeight=");
		s.append(getRelationPriceToWeight());
		s.append("]");
		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffee == null) ? 0 : coffee.hashCode());
		result = prime * result + volume;
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
		Bag other = (Bag) obj;
		if (coffee == null) {
			if (other.coffee != null) {
				return false;
			}
		} else if (!coffee.equals(other.coffee)) {
			return false;
		}
		if (volume != other.volume) {
			return false;
		}
		return true;
	}

	public String getContainerType() {
		return getClass().getSimpleName();
	}
}
