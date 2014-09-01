package by.epam.training.entity;

import org.apache.log4j.Logger;

public class Cashier {
	static Logger logger = Logger.getLogger(Cashier.class);
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void using(Visitor visitor) {
		try {
			Thread.sleep(visitor.getTime());
		} catch (InterruptedException e) {
			logger.equals(e);
		}
	}
}
