package studentmanage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanage.Dao.*;
import studentmanage.models.GradeInfo;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserClassDao c = new UserClassDao();	  
		request.setAttribute("userClass", c.getUserClassList());				
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");		
		request.getRequestDispatcher("/Grade/Edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		boolean Successed = false;

		String userid = request.getParameter("sltStudents");
		String chinese = request.getParameter("txtChinese");
		String maths = request.getParameter("txtMaths");
		String english = request.getParameter("txtEnglish");
		GradeDao dao=new GradeDao();
		GradeInfo info=new  GradeInfo();
		info.setUserid(Integer.parseInt(userid));
		info.setChinese(Float.parseFloat(chinese));
		info.setEnglish(Float.parseFloat(english));
		info.setMaths(Float.parseFloat(maths));
		Successed= dao.addGradeInfo(info);
		request.setAttribute("message", Successed);
		request.getRequestDispatcher("/Students/Edit.jsp").forward(request, response);
	}

}
