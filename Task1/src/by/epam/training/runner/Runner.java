package by.epam.training.runner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import by.epam.training.builder.CoffeeArabicaBuilder;
import by.epam.training.builder.CoffeeBuilder;
import by.epam.training.builder.CoffeeJacobsBuilder;
import by.epam.training.builder.CoffeeMaxwellHouseBuilder;
import by.epam.training.calculation.Calculation;
import by.epam.training.entity.Bag;
import by.epam.training.entity.Bank;
import by.epam.training.entity.Coffee;
import by.epam.training.entity.CoffeeState;
import by.epam.training.entity.Container;
import by.epam.training.entity.Wagon;

public class Runner {
	static {
		new DOMConfigurator().doConfigure("src\\log4j.xml",
				LogManager.getLoggerRepository());
	}
	static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		CoffeeBuilder arabicBuilder = new CoffeeArabicaBuilder();
		CoffeeBuilder jacobsBuilder = new CoffeeJacobsBuilder();
		CoffeeBuilder maxwellBuilder = new CoffeeMaxwellHouseBuilder();

		// making few sorts coffee with pricePerGram and CoffeeState
		Coffee arabic = arabicBuilder.getCoffee(2, CoffeeState.BEAN);
		Coffee jacobs = jacobsBuilder.getCoffee(1, CoffeeState.INSTANTE);
		Coffee maxwell = maxwellBuilder.getCoffee(3, CoffeeState.MILLED);

		// making few Banks and Bags with volume and some coffee
		Bank bank1 = new Bank(500, arabic);
		Bag bag1 = new Bag(500, arabic);
		Bag bag2 = new Bag(600, jacobs);
		Bank bank2 = new Bank(600, jacobs);
		Bank bank3 = new Bank(900, maxwell);
		Bag bag3 = new Bag(900, maxwell);

		// making wagon with some Capacity and Price
		Wagon wagon = new Wagon(200000, 200000);

		// add goods in wagon
		wagon.addContainer(bank1);
		wagon.addContainer(bag1);
		wagon.addContainer(bank2);
		wagon.addContainer(bag2);
		wagon.addContainer(bank3);
		wagon.addContainer(bag3);

		System.out.println(wagon);
		for (Container p : wagon.getListOfGoods()) {
			System.out.println(p);
		}
		System.out.println("Sorted By Ratio");
		for (Container p : Calculation.sortGoodsbyRatio(wagon.getListOfGoods())) {
			System.out.println(p);
		}
		System.out.println("get list Of Goods By Range");
		System.out.println(Calculation.getGoodsByRange(2, 3,
				wagon.getListOfGoods()));
	}
}
