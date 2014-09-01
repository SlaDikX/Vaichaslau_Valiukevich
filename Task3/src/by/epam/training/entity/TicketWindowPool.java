package by.epam.training.entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import by.epam.training.exception.Resour�eException;

public class TicketWindowPool<T> {

	private final static int POOL_SIZE = 3;
	private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
	private final Queue<TicketWindow> resources = new LinkedList<TicketWindow>();
	
	public TicketWindowPool(Queue<TicketWindow> source) {
		resources.addAll(source);
	}

	public TicketWindow getResource()
			throws Resour�eException {
		if (semaphore.tryAcquire()) {			
			TicketWindow res = resources.poll();
			return res;
		}
		throw new Resour�eException();
	}

	public void returnResource(TicketWindow res) {
		resources.add(res);
		semaphore.release();
	}
}
