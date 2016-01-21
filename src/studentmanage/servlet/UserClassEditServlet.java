package studentmanage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanage.Dao.UserClassDao;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class UserClassEditServlet
 */
@WebServlet("/EditUserClass")
public class UserClassEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UserClassEditServlet.class.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserClassEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		UserClassDao dao = new UserClassDao();
		String name = request.getParameter("txtName");
		String teacher = request.getParameter("txtTeacher");
		String phone = request.getParameter("txtPhone");
		// name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		// teacher = new String(teacher.getBytes("ISO-8859-1"), "UTF-8");
		// phone = new String(phone.getBytes("ISO-8859-1"), "UTF-8");
		boolean Successed = dao.addUserClassInfo(name, teacher, phone);
		logger.info(String.format("name= %s , teacher= %s , phone = %s", name, teacher, phone));
		request.setAttribute("message", Successed);
		request.getRequestDispatcher("/UserClass/Edit.jsp").forward(request, response);
	}

	/**
	 * Ïú»Ù
	 */
	public void destroy() {
		super.destroy();
	}
}
