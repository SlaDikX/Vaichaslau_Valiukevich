package by.epam.training.builders;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.entity.Bag;
import by.epam.training.entity.Bank;
import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;
import by.epam.training.entity.Package;

public class GoodsBuilder {
	public static List<Package> prepareCoffee() {

		List<Package> goodsList = new ArrayList<Package>();
		
		// coffee name with price per gram
		Coffee coffe1 = new Coffee("Jacobs", 3);
		Coffee coffe2 = new Coffee("Nescafe", 2);
		Coffee coffe3 = new Coffee("Maxwell House", 1);
		Coffee coffe4 = new Coffee("Arabica", 4);
		
		// creating few banks and bags certain volume and state of coffee
		Bank bank1 = new Bank(500, coffe1, CoffeeState.BEAN);
		Bank bank2 = new Bank(600, coffe2, CoffeeState.INSTANTE);
		Bag bag1 = new Bag(100, coffe3, CoffeeState.MILLED);
		Bag bag2 = new Bag(400, coffe4, CoffeeState.BEAN);
		
		goodsList.add(bag1);
		goodsList.add(bag2);
		goodsList.add(bank1);
		goodsList.add(bank2);

		return goodsList;
	}
}
