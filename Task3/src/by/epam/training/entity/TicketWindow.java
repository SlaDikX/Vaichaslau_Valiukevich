package by.epam.training.entity;

import java.util.LinkedList;
import java.util.List;

public class TicketWindow {
	LinkedList<Cashier> list;
	private String ticketWindowName;
	private Visitor currentReference;

	public Visitor getVisitorReference() {
		return currentReference;
	}

	public TicketWindow(String ticketWindowName) {
		this.ticketWindowName = ticketWindowName;
	}

	public String getTicketWindowName() {
		return ticketWindowName;
	}

	@SuppressWarnings("serial")
	public void using(List<Visitor> visitors) {
		 list = new LinkedList<Cashier>() {
			{
				this.add(new Cashier());
			}
		};

		CashierPool<Cashier> cashierPool = new CashierPool<>(list);
		for (Visitor visitor : visitors) {
			visitor.setReference(visitor);
			visitor.setName(visitor.getName()+" in "+ getTicketWindowName());
			visitor.setCashierPool(cashierPool);			
			Thread thread = new Thread(visitor);
			thread.start();
			
		}

	}

}
