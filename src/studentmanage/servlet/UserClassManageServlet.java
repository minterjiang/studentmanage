package studentmanage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import studentmanage.Common.PageModel;
import studentmanage.Dao.UserClassDao;

/**
 * Servlet implementation class UserClassManageServlet
 */
@WebServlet("/UserClassManageServlet")
public class UserClassManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UserClassEditServlet.class.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserClassManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int pageIndex = 1;
			if (request.getParameter("p") != null) {
				pageIndex = Integer.parseInt(request.getParameter("p"));
			}
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			UserClassDao dao = new UserClassDao();
			if (request.getParameter("delId") != null) {
				int id = Integer.parseInt(request.getParameter("delId"));
				boolean Successed = dao.deleteUserClassInfo(id);
				request.setAttribute("message", Successed);
			}
			int pageSize=10;
			int total=dao.getUserClassListCount();
			PageModel p=new PageModel(pageIndex,total,"UserClassManageServlet",pageSize);
			request.setAttribute("Pager", p.GetPager());			
			request.setAttribute("oList", dao.getUserClassList(pageIndex, pageSize));
			request.getRequestDispatcher("/UserClass/UserClassManage.jsp").forward(request, response);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
