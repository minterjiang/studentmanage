package studentmanage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentmanage.Dao.StudentDao;
import studentmanage.models.StudentInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String name = request.getParameter("loginName");
		String pwd = request.getParameter("loginPwd");
		StudentDao dao = new StudentDao();
		StudentInfo info=dao.login(name, pwd);
		if(info!=null && info.getId()>0)
		{
			HttpSession session = request.getSession(); 
			session.setAttribute("user", info);
			response.sendRedirect("Index.jsp");
		}
		else{
			request.setAttribute("message", "账号或密码不正确！");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	 
	}

}
