package by.epam.training.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import by.epam.training.entity.QueueOfVisitors;

public class QueueOfVisitorsPool<T> {
	private final static int POOL_SIZE = 3;
	private Lock lock = new ReentrantLock();
	private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
	private final Queue<QueueOfVisitors> resources = new LinkedList<QueueOfVisitors>();

	public QueueOfVisitorsPool (List<QueueOfVisitors> source) {
		resources.addAll(source);
	}

	public  QueueOfVisitors getResource() {
		QueueOfVisitors queueOfVisitors = null;
		lock.lock();
		if (semaphore.tryAcquire()) {
			queueOfVisitors = resources.poll();
		}
		lock.unlock();
		return queueOfVisitors;
	}

	public void returnResource(QueueOfVisitors queueOfVisitors) {
		lock.lock();
		resources.add(queueOfVisitors);
		semaphore.release();
		lock.unlock();
	}
	
}
