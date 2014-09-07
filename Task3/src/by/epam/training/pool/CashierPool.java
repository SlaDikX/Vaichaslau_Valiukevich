package by.epam.training.pool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.epam.training.entity.Cashier;
import by.epam.training.entity.Visitor;
import by.epam.training.exception.Resour�eException;

public class CashierPool<T> {
	static Logger logger = Logger.getLogger(CashierPool.class);
	private final static int POOL_SIZE = 1;
	private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
	private final Queue<Cashier> resources = new LinkedList<Cashier>();
	private Lock lock = new ReentrantLock();

	public CashierPool(Queue<Cashier> source) {
		resources.addAll(source);
	}

	public Cashier getResource(Visitor visitor) throws Resour�eException {
		lock.lock();
		try {
			if (semaphore.tryAcquire(visitor.getTime(), TimeUnit.MILLISECONDS)) {
				Cashier res = resources.poll();
				return res;
			}
		} catch (InterruptedException e) {
			throw new Resour�eException(e);
		} finally {
			lock.unlock();
		}
		throw new Resour�eException(" cant wait ");
	}

	public void returnResource(Cashier res) {
		resources.add(res);
		semaphore.release();
	}
}
