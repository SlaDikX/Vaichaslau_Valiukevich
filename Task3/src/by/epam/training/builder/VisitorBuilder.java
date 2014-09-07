package by.epam.training.builder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import by.epam.training.entity.QueueOfVisitors;
import by.epam.training.entity.Visitor;
import by.epam.training.pool.QueueOfVisitorsPool;

public class VisitorBuilder {
	public static BlockingQueue<Visitor> fillVisitors(int numberOfVisitors,
			QueueOfVisitorsPool<QueueOfVisitors> listOfQueueOfVisitorsPool) {
		BlockingQueue<Visitor> visitors = new ArrayBlockingQueue<Visitor>(
				numberOfVisitors);
		for (int i = 1; i <= numberOfVisitors; i++) {
			visitors.add(new Visitor(listOfQueueOfVisitorsPool, "Visitor " + i));
		}
		return visitors;
	}
}