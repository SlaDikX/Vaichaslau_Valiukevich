package by.epam.training.builder;

import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;

public final class CoffeeBuilder {
	public static Coffee buildCoffee(String name, int pricePerGram, CoffeeState state) {
		Coffee coffee = new Coffee(name, pricePerGram, state);
		return coffee;
	}
}
