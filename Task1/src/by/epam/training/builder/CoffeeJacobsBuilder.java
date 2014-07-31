package by.epam.training.builder;

import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;

public class CoffeeJacobsBuilder implements CoffeeBuilder {

	@Override
	public Coffee getCoffee(int pricePerGram, CoffeeState state) {
		Coffee coffee = new Coffee("Jacobs",pricePerGram,state);
		return coffee;
	}
}
