package by.epam.training.entity;

import org.apache.log4j.Logger;

import by.epam.training.exception.ResourñeException;

public class Visitor implements Runnable {
	static Logger logger = Logger.getLogger(Visitor.class);
	private static final int time = 1 + (int) (Math.random() * ((100) + 1));
	private String name;
	private Visitor currentReference;
	private CashierPool<Cashier> cashierPool;

	public Visitor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCashierPool(CashierPool<Cashier> cashierPool) {
		this.cashierPool = cashierPool;
	}

	public void setReference(Visitor visitor) {
		currentReference = visitor;
	}

	public int getTime() {
		return time;
	}

	public void run() {
		Cashier cashier = null;
		try {
			cashier = cashierPool.getResource(currentReference);
			cashier.using(currentReference);
		} catch (ResourñeException e) {
			logger.info(currentReference.getName() + " " + e.getMessage());
		} finally {
			if (cashier != null) {
				cashierPool.returnResource(cashier);
			}
		}
	}

}
