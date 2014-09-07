package by.epam.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.epam.training.pool.TicketWindowPool;

public class QueueOfVisitors extends Thread {
	static Logger logger = Logger.getLogger(QueueOfVisitors.class);
	private int numberOfQueue;
	private List<Visitor> visitors = new ArrayList<Visitor>();
	private TicketWindowPool<TicketWindow> ticketWindowPool;
	private Lock lock = new ReentrantLock();

	public QueueOfVisitors(int numberOfQueue,
			TicketWindowPool<TicketWindow> ticketWindowPool) {
		this.numberOfQueue = numberOfQueue;
		this.ticketWindowPool = ticketWindowPool;
	}

	public void addVisitor(Visitor visitor) {
		lock.lock();
		visitor.setNumberOfQueue(numberOfQueue);
		visitors.add(visitor);
		lock.unlock();
	}

	public int getNumberOfQueue() {
		return numberOfQueue;
	}

	public void run() {
		TicketWindow ticketWindow = null;
		ticketWindow = ticketWindowPool.getResource();
		ticketWindow.usingCashier(visitors);
		ticketWindowPool.returnResource(ticketWindow);
	}

}
