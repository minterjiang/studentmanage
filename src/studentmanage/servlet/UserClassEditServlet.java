package studentmanage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import studentmanage.Dao.UserClassDao;
import studentmanage.models.UserClassInfo;

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
		String editId = request.getParameter("editId");
		UserClassDao dao = new UserClassDao();
		int id=0;
		if (editId != null && !editId.isEmpty()) {
			id = Integer.parseInt(editId);
		}
		if (id > 0) {
			UserClassInfo info = dao.getUserClass(id);
			request.setAttribute("info", info);
		}
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// request.setAttribute("message", Successed);
		request.getRequestDispatcher("/UserClass/Edit.jsp").forward(request, response);
		// doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String editId = request.getParameter("editId");
		UserClassDao dao = new UserClassDao();
		boolean Successed = false;
		String name = request.getParameter("txtName");
		String teacher = request.getParameter("txtTeacher");
		String phone = request.getParameter("txtPhone");

		int id = 0;

		if (editId != null && !editId.isEmpty()) {
			id = Integer.parseInt(editId);
		}

		if (id > 0) {// 修改
			UserClassInfo info = dao.getUserClass(id);
			if (info != null) {
				info.setName(name);
				info.setTeacher(teacher);
				info.setPhone(phone);
				Successed = dao.updateUserClassInfo(info);
			}
		} else
		{// 新增

			Successed = dao.addUserClassInfo(name, teacher, phone);
			logger.info(String.format("name= %s , teacher= %s , phone = %s", name, teacher, phone));
		}
		request.setAttribute("message", Successed);
		request.getRequestDispatcher("/UserClass/Edit.jsp").forward(request, response);
	}

	/**
	 * 销毁
	 */
	public void destroy() {
		super.destroy();
	}
}
