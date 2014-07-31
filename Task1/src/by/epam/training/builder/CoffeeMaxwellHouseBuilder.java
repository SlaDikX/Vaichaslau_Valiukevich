package by.epam.training.builder;

import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;

public class CoffeeMaxwellHouseBuilder implements CoffeeBuilder {

	@Override
	public Coffee getCoffee(int pricePerGram, CoffeeState state) {
		Coffee coffee = new Coffee("MaxwellHouse",pricePerGram,state);
		return coffee;
		}

}
