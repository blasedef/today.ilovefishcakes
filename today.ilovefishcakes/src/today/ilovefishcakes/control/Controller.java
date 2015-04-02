package today.ilovefishcakes.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import today.ilovefishcakes.model.Model;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
	private String ascii;
	private String texts;
	
	@Override
	public void init() throws ServletException {
		
		try {
			model = new Model();
		} catch (Exception e) {
			getServletContext().log("We loved the fishcakes maybe too much :(", e);
			throw new ServletException("We loved the fishcakes maybe too much :("
					+ e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("text", model.getText());
		request.setAttribute("ascii", model.getAscii());
		
		RequestDispatcher view = request.getRequestDispatcher("View.jsp");
		
		view.forward(request, response);
	}

}
