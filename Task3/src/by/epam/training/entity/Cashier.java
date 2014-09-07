package by.epam.training.entity;

import java.util.concurrent.TimeUnit;

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
			logger.info(visitor.getName() + " from queue# "
					+ visitor.getNumberOfQueue() + " was in TicketWindow "
					+ visitor.getNumberOfTicketWindow());
			TimeUnit.MILLISECONDS.sleep(visitor.getTime());
		} catch (InterruptedException e) {
			logger.error(e);
		}

	}

}
