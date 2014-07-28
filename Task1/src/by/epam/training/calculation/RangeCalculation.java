package by.epam.training.calculation;

import java.util.ArrayList;
import java.util.List;
import by.epam.training.entity.Package;

public class RangeCalculation {
	public static List<Package> getGoodsByRange(int minRatio, int maxRatio,
			List<Package> list) {
		List<Package> rangedList = new ArrayList<Package>();
		for (Package p : list) {
			if (p.getRelationPriceToWeight() >= minRatio
					&& p.getRelationPriceToWeight() <= maxRatio) {
				rangedList.add(p);
			}
		}
		return rangedList;
	}
}
