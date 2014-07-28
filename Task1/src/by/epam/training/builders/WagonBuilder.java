package by.epam.training.builders;

import java.util.List;
import by.epam.training.entity.Package;
import by.epam.training.entity.Wagon;

public class WagonBuilder {

	public static Wagon fillWagon(int capacityOfWagon, int priceOfWagon,
			List<Package> listOfGoods) {

		int totalCapacity = 0;
		int totalPrice = 0;
		for (Package p : listOfGoods) {
			totalPrice += p.getPrice();
			totalCapacity += p.getVolume();
		}
		if (totalCapacity <= capacityOfWagon && totalPrice <= priceOfWagon) {
			Wagon wagon = new Wagon(totalCapacity, totalPrice, listOfGoods);
			return wagon;
		} else
			return null;
	}
}
