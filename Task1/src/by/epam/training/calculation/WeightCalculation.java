package by.epam.training.calculation;

import by.epam.training.entity.CoffeeState;

public class WeightCalculation {
	public static int calculateWeight(int volume, CoffeeState state) {
		return volume * state.getDensity();
	}
}
