package by.epam.training.runner;

import java.util.LinkedList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.training.entity.QueueVisitors;
import by.epam.training.entity.TicketWindow;
import by.epam.training.entity.TicketWindowPool;

public class Runner {
	static Logger logger = Logger.getLogger(Runner.class);
	
	static {
		new DOMConfigurator().doConfigure("property\\log4j.xml",
				LogManager.getLoggerRepository());
	}
	
	public static void main(String[] args) {

		@SuppressWarnings("serial")
		LinkedList<TicketWindow> list = new LinkedList<TicketWindow>() {
			{
				this.add(new TicketWindow("Window-1"));
				this.add(new TicketWindow("Window-2"));
				this.add(new TicketWindow("Window-3"));
			}
		};

		TicketWindowPool<TicketWindow> pool = new TicketWindowPool<>(list);
		for (int i = 1; i <= list.size(); i++) {
			QueueVisitors qVisititors = new QueueVisitors(pool, i);
			qVisititors.start();

		}

	}

}
