package by.epam.training.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import by.epam.training.calculation.Calculation;

public class Wagon implements Comparable<Wagon>, Cloneable {
	static Logger logger = Logger.getLogger(Wagon.class);
	private int wagonCapacity=0;
	private int wagonPrice=0;
	private List<Container> listOfGoods = new ArrayList<Container>();

	public Wagon(int wagonCapacity, int wagonPrice) {

		try {
			if (wagonCapacity <= 0) {
				throw new IllegalArgumentException("wagonCapacity");
			} else if (wagonPrice <= 0) {
				throw new IllegalArgumentException("wagonPrice");
			} else {
				this.wagonCapacity = wagonCapacity;
				this.wagonPrice = wagonPrice;
			}
		} catch (IllegalArgumentException e) {
			logger.error(e + " of making Wagon");
		}
	}

	public int getWagonCapacity() {
		return wagonCapacity;
	}

	public int getWagonPrice() {
		return wagonPrice;
	}

	public List<Container> getListOfGoods() {
		return Collections.unmodifiableList(listOfGoods);
	}

	public int getFreeMoney() {
		return Calculation.calculateFreeWagonMoney(wagonPrice, listOfGoods);
	}

	public int getFreeSpace() {
		return Calculation.calculateFreeWagonSpace(wagonCapacity, listOfGoods);
	}

	public void addContainer(Container container) {
		if (getFreeSpace() < container.getVolume()) {
			logger.info(container.getClass().getSimpleName() + " "
					+ container.getCoffee().getName()
					+ " Not enouth free capacity in wagon");
		} else if (getFreeMoney() < container.getPrice()) {
			logger.info(container.getClass().getSimpleName() + " "
					+ container.getCoffee().getName() + " No money left ");
		} else {
			listOfGoods.add(container);
		}
	}

	@Override
	public int compareTo(Wagon o) {
		return this.getWagonPrice() - o.getWagonPrice();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Wagon [Capacity=");
		s.append(wagonCapacity);
		s.append(", Price=");
		s.append(wagonPrice);
		s.append(", FreeMoney=");
		s.append(getFreeMoney());
		s.append(", FreeSpace=");
		s.append(getFreeSpace());
		s.append("]");
		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listOfGoods == null) ? 0 : listOfGoods.hashCode());
		result = prime * result + wagonCapacity;
		result = prime * result + wagonPrice;
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
		Wagon other = (Wagon) obj;
		if (listOfGoods == null) {
			if (other.listOfGoods != null) {
				return false;
			}
		} else if (!listOfGoods.equals(other.listOfGoods)) {
			return false;
		}
		if (wagonCapacity != other.wagonCapacity) {
			return false;
		}
		if (wagonPrice != other.wagonPrice) {
			return false;
		}
		return true;
	}
}