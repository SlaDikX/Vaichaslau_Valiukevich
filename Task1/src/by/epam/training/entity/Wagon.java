package by.epam.training.entity;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
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
		StringBuilder s = new StringBuilder("Wagon [wagonCapacity=" + wagonCapacity + ", totalPrice="
				+ totalPrice + ", listOfGoods=" + listOfGoods + "]");
		return s.toString();
	}
}