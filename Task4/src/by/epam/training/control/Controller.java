package by.epam.training.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.training.builder.WagonBuilder;
import by.epam.training.entity.Wagon;
import by.epam.training.exception.WagonBuilderLogicalException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Controller.class);

	public Controller() {
		super();
	}

	public void init() throws ServletException {
		{
			String file = "WEB-INF/log4j.xml";
			String prefix = getServletContext().getRealPath("/");
			new DOMConfigurator().doConfigure(prefix + file,
					LogManager.getLoggerRepository());
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parserName = request.getParameter("parser-name").toUpperCase()
				.trim();
		String prefix = getServletContext().getRealPath("/");
		String path = prefix + "resourse/WagCof.xml";
		try {
			Wagon wagon = WagonBuilder.buildWagon(parserName, path);
			request.setAttribute("res", wagon);
			request.setAttribute("parser", parserName);
			request.getRequestDispatcher("/jsp/result.jsp").forward(request,
					response);
		} catch (WagonBuilderLogicalException e) {
			logger.error(e);
			request.getRequestDispatcher("/jsp/error.jsp").forward(request,
					response);
		}
	}
}
