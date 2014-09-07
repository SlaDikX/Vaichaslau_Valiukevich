package by.epam.training.logic;
import java.util.concurrent.Exchanger;

import by.epam.training.entity.Visitor;

public class VisitorAction {
	private static Exchanger<Visitor> exchanger = new Exchanger<>();
	public static Exchanger<Visitor> getExchanger() {
		return exchanger;
	}	
}
