package by.epam.training.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;
import by.epam.training.exception.ResourñeException;
import by.epam.training.logic.VisitorAction;
import by.epam.training.pool.CashierPool;
import by.epam.training.pool.QueueOfVisitorsPool;

public class Visitor implements Runnable {
	
	private static final int TIME = 1 + (int) (Math.random() * ((1000) + 1));
	private Lock lock = new ReentrantLock();
	private CashierPool<Cashier> cashierPool;
	private String name;
	private QueueOfVisitorsPool<QueueOfVisitors> queuesOfVisitorsPool;
	private int numberOfQueue;
	private int numberOfTicketWindow;
	private Visitor visitorFromOtherQueue;
	static Logger logger = Logger.getLogger(Visitor.class);

	public Visitor(
			QueueOfVisitorsPool<QueueOfVisitors> listOfQueueOfVisitorsPool,
			String name) {
		this.setName(name);
		this.queuesOfVisitorsPool = listOfQueueOfVisitorsPool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return TIME;
	}

	public void setCashierPool(CashierPool<Cashier> cashierPool) {
		this.cashierPool = cashierPool;
	}

	public int getNumberOfQueue() {
		return numberOfQueue;
	}

	public void setNumberOfQueue(int numberOfQueue) {
		this.numberOfQueue = numberOfQueue;
	}

	public int getNumberOfTicketWindow() {
		return numberOfTicketWindow;
	}

	public void setNumberOfTicketWindow(int numberOfTicketWindow) {
		this.numberOfTicketWindow = numberOfTicketWindow;
	}

	public void usingQueue() {
		lock.lock();
		QueueOfVisitors res = null;
		res = queuesOfVisitorsPool.getResource();
		logger.info(name + " " + "go in " + res.getNumberOfQueue() + " queue");
		res.addVisitor(this);
		queuesOfVisitorsPool.returnResource(res);
		lock.unlock();
	}

	@Override
	public void run() {
		Cashier cashier = null;
		try {
			cashier = cashierPool.getResource(this);
			cashier.using(this);
		} catch (ResourñeException e) {
			logger.info(this.getName() + " from queue#"
					+ this.getNumberOfQueue() + " " + e.getMessage());
			String temp = this.getName() + " from queue#"
					+ this.getNumberOfQueue();
			try {
				lock.lock();
				visitorFromOtherQueue = (Visitor) VisitorAction.getExchanger()
						.exchange(this, 100, TimeUnit.MILLISECONDS);
				logger.info(visitorFromOtherQueue.getName() + " from queue#"
						+ visitorFromOtherQueue.getNumberOfQueue()
						+ " cheange with " + temp);
				lock.unlock();
			} catch (InterruptedException e1) {
				logger.error(e1);
			} catch (TimeoutException e1) {
				logger.info(this.getName() + " went away");
			}
		} finally {
			if (cashier != null) {
				cashierPool.returnResource(cashier);
			}
		}
	}
}
