package by.epam.training.entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import by.epam.training.exception.ResourñeException;
import by.epam.training.logic.VisitorAction;

public class CashierPool<T> {
	static Logger logger = Logger.getLogger(CashierPool.class);
	private final Semaphore semaphore = new Semaphore(1, true);
	private final Queue<Cashier> resources = new LinkedList<Cashier>();

	public CashierPool(Queue<Cashier> qCashiers) {
		resources.addAll(qCashiers);
	}

	public Cashier getResource(Visitor visitor) throws ResourñeException {

		try {
			if (semaphore.tryAcquire(visitor.getTime(), TimeUnit.MILLISECONDS)) {
				Cashier res = resources.poll();
				logger.info(visitor.getName());
				return res;
			} else {
				synchronized (visitor) {
					String temp = visitor.getName();
					visitor = (Visitor) VisitorAction.getExchanger().exchange(visitor);
					visitor.setName(visitor.getName() + " cheange with " + temp);
					logger.info(visitor.getName());
				}
			}
		} catch (InterruptedException e) {
			throw new ResourñeException(e);
			}
		throw new ResourñeException(" went away");
	}

	public void returnResource(Cashier res) {
		resources.add(res);
		semaphore.release();
	}
}
