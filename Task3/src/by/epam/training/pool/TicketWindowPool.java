package by.epam.training.pool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import by.epam.training.entity.TicketWindow;

public class TicketWindowPool<WindowTicket> {
	private Lock lock = new ReentrantLock();
	private final static int POOL_SIZE = 3;
	private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
	private final Queue<TicketWindow> resources = new LinkedList<TicketWindow>();

	public TicketWindowPool(Queue<TicketWindow> source) {
		resources.addAll(source);
	}

	public TicketWindow getResource() {
		TicketWindow ticketWindow = null;
		lock.lock();
		if (semaphore.tryAcquire()) {
			ticketWindow = resources.poll();
		}
		lock.unlock();
		return ticketWindow;
	}

	public void returnResource(TicketWindow ticketWindow) {
		lock.lock();
		resources.add(ticketWindow);		
		semaphore.release();
		lock.unlock();
	}
}
