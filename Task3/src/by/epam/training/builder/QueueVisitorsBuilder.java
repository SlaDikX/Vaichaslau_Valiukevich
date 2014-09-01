package by.epam.training.builder;

import java.util.LinkedList;
import java.util.List;
import by.epam.training.entity.Visitor;

public class QueueVisitorsBuilder {
	private static List<Visitor> queue;
	private static Visitor visitor;

	public static List<Visitor> buildQueueOfVisitors(int queueNumber) {
		queue = new LinkedList<Visitor>();
		for (int i = 0; i < 100; i++) {
			visitor = new Visitor("Visitor #" + i +" from queueNumber # "+queueNumber);
			queue.add(visitor);
		}
		return queue;
	}

	public List<Visitor> getQueue() {
		return queue;
	}

}
