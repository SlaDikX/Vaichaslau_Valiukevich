package by.epam.training.runner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import by.epam.training.builder.VisitorBuilder;
import by.epam.training.entity.QueueOfVisitors;
import by.epam.training.entity.TicketWindow;
import by.epam.training.entity.Visitor;
import by.epam.training.pool.QueueOfVisitorsPool;
import by.epam.training.pool.TicketWindowPool;

public class Runner {
	static Logger logger = Logger.getLogger(Runner.class);

	static {
		new DOMConfigurator().doConfigure("property\\log4j.xml",
				LogManager.getLoggerRepository());
	}

	public static void main(String[] args) {
		 
		LinkedList<TicketWindow> listOfTicketWindows = new LinkedList<TicketWindow>();
		listOfTicketWindows.add(new TicketWindow(1));
		listOfTicketWindows.add(new TicketWindow(2));
		listOfTicketWindows.add(new TicketWindow(3));
		TicketWindowPool<TicketWindow> pool = new TicketWindowPool<>(
				listOfTicketWindows);
		
		List<QueueOfVisitors> listOfVisitorsQueues = new ArrayList<QueueOfVisitors>();
		listOfVisitorsQueues.add(new QueueOfVisitors(1, pool));
		listOfVisitorsQueues.add(new QueueOfVisitors(2, pool));
		listOfVisitorsQueues.add(new QueueOfVisitors(3, pool));
		QueueOfVisitorsPool<QueueOfVisitors> queueOfVisitorsPool = new QueueOfVisitorsPool<>(
				listOfVisitorsQueues);

		// creating some number of visitors
		BlockingQueue<Visitor> outsideVisitors = VisitorBuilder.fillVisitors(
				300, queueOfVisitorsPool);

		// its like a door in some building ... visitor open door
		// and go in some queue from existing queues
		for (Visitor visitor : outsideVisitors) {
			visitor.usingQueue();
		}
		//Visitors queues take some TicketWindow and visitors from queue start use Cashier from TicketWindow 
		for (QueueOfVisitors queueOfVisitors : listOfVisitorsQueues) {
			queueOfVisitors.start();
		}

	}
}
