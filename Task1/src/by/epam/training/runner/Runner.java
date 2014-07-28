package by.epam.training.runner;
import java.util.List;

import by.epam.training.builders.GoodsBuilder;
import by.epam.training.builders.WagonBuilder;
import by.epam.training.calculation.RangeCalculation;
import by.epam.training.calculation.Sorting;
import by.epam.training.entity.Package;
import by.epam.training.entity.Wagon;

public class Runner {
	
		public static void main(String[] args) {
			List<Package> list = GoodsBuilder.prepareCoffee();
			Wagon wagon = WagonBuilder.fillWagon(200000, 200000, list);
			for (Package p : wagon.getListOfGoods()) {
				System.out.println(p);
			}
			System.out.println("Sorted by ratio");
			Sorting.sortGoodsbyRatio(wagon.getListOfGoods());
			for (Package p : list) {
				System.out.println(p);
				
			}
			System.out.println("find by range");
			for (Package p:RangeCalculation.getGoodsByRange(1, 3, wagon.getListOfGoods())){
				System.out.println(p);
			}
		}
}
