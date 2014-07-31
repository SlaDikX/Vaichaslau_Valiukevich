package by.epam.training.builder;

import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;

public interface CoffeeBuilder {
	public abstract Coffee getCoffee(int pricePerGram, CoffeeState state);
}
