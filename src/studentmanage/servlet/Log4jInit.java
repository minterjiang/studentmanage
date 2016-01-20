package studentmanage.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Log4jInit
 */
@WebServlet("/Log4jInit")
public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
	}

	public Log4jInit() {
		super();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		String file = this.getInitParameter("log4j");// ��web.xml���ö�ȡ������һ��Ҫ��web.xml����һ��
		if (file != null) {
			PropertyConfigurator.configure(file);
		}
	}

}
