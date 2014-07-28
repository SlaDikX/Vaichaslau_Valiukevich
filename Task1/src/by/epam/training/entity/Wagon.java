package by.epam.training.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wagon implements Comparable<Wagon>, Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4955186466689315452L;
	private int wagonCapacity;
	private int totalPrice;
	private List<Package> listOfGoods = new ArrayList<Package>();

	public Wagon(int capacity, int price, List<Package> listOfGoods) {
		super();
		this.wagonCapacity = capacity;
		this.totalPrice = price;
		this.listOfGoods = listOfGoods;
	}

	public int getWagonCapacity() {
		return wagonCapacity;
	}

	public int getWagonPrice() {
		return totalPrice;
	}

	public List<Package> getListOfGoods() {
		return listOfGoods;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Wagon [wagonCapacity="
				+ wagonCapacity + ", totalPrice=" + totalPrice
				+ ", listOfGoods=" + listOfGoods + "]");
		return s.toString();
	}

	@Override
	public int compareTo(Wagon o) {
		return this.getWagonPrice() - o.getWagonPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listOfGoods == null) ? 0 : listOfGoods.hashCode());
		result = prime * result + totalPrice;
		result = prime * result + wagonCapacity;
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
		Wagon other = (Wagon) obj;
		if (listOfGoods == null) {
			if (other.listOfGoods != null)
				return false;
		} else if (!listOfGoods.equals(other.listOfGoods))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		if (wagonCapacity != other.wagonCapacity)
			return false;
		return true;
	}
	
}