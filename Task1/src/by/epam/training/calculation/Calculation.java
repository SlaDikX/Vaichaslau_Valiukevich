package by.epam.training.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import by.epam.training.entity.CoffeeState;
import by.epam.training.entity.Container;

public class Calculation {
	static Logger logger = Logger.getLogger(Calculation.class);
	public static int calculatePrice(int weight, int pricePerGram) {
		return weight * pricePerGram;
	}

	public static List<Container> getGoodsByRange(int minRatio, int maxRatio,
			List<Container> list) {
		List<Container> rangedList = new ArrayList<Container>();
		for (Container p : list) {
			if (p.getRelationPriceToWeight() >= minRatio
					&& p.getRelationPriceToWeight() <= maxRatio) {
				rangedList.add(p);
			}
		}
		return rangedList;
	}

	public static int calculateWeight(int volume, CoffeeState state) {
		return volume * state.getDensity();
	}

	public static List<Container> sortGoodsbyRatio(List<Container> list) {
		List<Container> sortedList = new ArrayList<Container>();
		sortedList.addAll(list);
		Collections.sort(sortedList);
		return Collections.unmodifiableList(sortedList);
	}

	public static int calculateFreeWagonSpace(int wagonCapacity,
			List<Container> listOfGoods) {
		if (listOfGoods.size() == 0) {
			return wagonCapacity;
		} else {
			int allGoogsVolume = 0;
			for (Container c : listOfGoods) {
				allGoogsVolume += c.getVolume();
			}
			return wagonCapacity - allGoogsVolume;
		}
	}

	public static int calculateFreeWagonMoney(int wagonPrice,
			List<Container> listOfGoods) {
		if (listOfGoods.size() == 0) {
			return wagonPrice;
		} else {
			int allGoodsPrice = 0;
			for (Container c : listOfGoods) {
				allGoodsPrice += c.getPrice();
			}
			return wagonPrice - allGoodsPrice;
		}
	}
}
