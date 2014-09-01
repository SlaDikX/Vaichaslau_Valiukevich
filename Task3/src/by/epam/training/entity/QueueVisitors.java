package by.epam.training.entity;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.training.builder.QueueVisitorsBuilder;
import by.epam.training.exception.ResourñeException;

public class QueueVisitors extends Thread {
	static Logger logger = Logger.getLogger(QueueVisitors.class);
	private int queueNumber;
	private TicketWindowPool<TicketWindow> ticketWindowPool;
	private List<Visitor> quList;

	public QueueVisitors(TicketWindowPool<TicketWindow> ticketWindowPool,
			int queueNumber) {
		this.ticketWindowPool = ticketWindowPool;
		this.quList = QueueVisitorsBuilder.buildQueueOfVisitors(queueNumber);
		this.queueNumber = queueNumber;
	}

	public int getQueueNumber() {
		return queueNumber;
	}

	public void run() {
		TicketWindow ticketWindow = null;
		try {
			ticketWindow = ticketWindowPool.getResource();
			ticketWindow.using(quList);
		} catch (ResourñeException e) {
			logger.info(e.getMessage());
		} finally {
			if (ticketWindow != null) {
				ticketWindowPool.returnResource(ticketWindow);
			}
		}
	}
}
