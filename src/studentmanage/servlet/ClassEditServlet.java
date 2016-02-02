package studentmanage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import studentmanage.Dao.StudentDao;
import studentmanage.Dao.UserClassDao;
import studentmanage.models.StudentInfo;

/**
 * Servlet implementation class ClassEditServlet
 */
@WebServlet("/EditClass")
public class ClassEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassEditServlet() {
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
		StudentDao dao = new StudentDao();
		int id = 0;
		if (editId != null && !editId.isEmpty()) {
			id = Integer.parseInt(editId);
		}
		if (id > 0) {
			StudentInfo info = dao.getStudentInfo(id);
			request.setAttribute("info", info);
		}
		UserClassDao c = new UserClassDao();
		request.setAttribute("userClass", c.getUserClassList());
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// request.setAttribute("message", Successed);
		request.getRequestDispatcher("/Students/Edit.jsp").forward(request, response);
		// doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String editId = request.getParameter("editId");
		StudentDao dao = new StudentDao();
		boolean Successed = false;
		String account = request.getParameter("txtAccount");
		String name = request.getParameter("txtName");
		String password = request.getParameter("txtPassWord");
		String password2 = request.getParameter("txtPassWord2");
		String sltClassId = request.getParameter("sltClassId");
		if(!password2.equals(password))
		{
		 //两次输入密码不相同
		}
		
		int id = 0;
		StudentInfo info = new StudentInfo();
		if (editId != null && !editId.isEmpty()) {
			id = Integer.parseInt(editId);
			info = dao.getStudentInfo(id);
		}
		info.setAccount(account);
		info.setName(name);
		info.setPassword(password2);
		info.setUserclassid(Integer.parseInt(sltClassId));

		if (id > 0) {// 修改
			Successed = dao.updateUserClassInfo(info);
		} else {// 新增
			Successed = dao.addStudentInfo(info);
		}
		request.setAttribute("message", Successed);
		request.getRequestDispatcher("/Students/Edit.jsp").forward(request, response);
	}

	/**
	 * 销毁
	 */
	public void destroy() {
		super.destroy();
	}
}
