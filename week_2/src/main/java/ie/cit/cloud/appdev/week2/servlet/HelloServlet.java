package ie.cit.cloud.appdev.week2.servlet;

import static java.lang.String.format;
import ie.cit.cloud.appdev.week2.Calculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HelloServlet extends HttpServlet implements HttpRequestHandler {

	private Calculator calc;

	public HelloServlet(Calculator calc) {
		this.calc = calc;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		long factorial = calc.factorial(4);
		String msg = format("Factorial of 3 is %d using \"%s\".", factorial,
				calc.toString());
		resp.getWriter().println(msg);
	}

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
