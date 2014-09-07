package by.epam.training.entity;
import java.util.LinkedList;
import java.util.List;
import by.epam.training.pool.CashierPool;

public class TicketWindow {
	private LinkedList<Cashier> list;
	private int numberOfTicketWindow;

	public TicketWindow(int numberOfTicketWindow) {
		this.numberOfTicketWindow = numberOfTicketWindow;
	}

	public int getNumberOfTicketWindow() {
		return numberOfTicketWindow;
	}

	public void usingCashier(List<Visitor> visitors) {
		list = new LinkedList<Cashier>();
		list.add(new Cashier());
		CashierPool<Cashier> cashierPool = new CashierPool<>(list);
		for (Visitor visitor : visitors) {
			visitor.setCashierPool(cashierPool);
			visitor.setNumberOfTicketWindow(numberOfTicketWindow);
			Thread thread = new Thread(visitor);
			thread.start();
		}
	}
}
