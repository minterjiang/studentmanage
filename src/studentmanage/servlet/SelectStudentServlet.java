package studentmanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import studentmanage.Common.JsonDateValueProcessor;
import studentmanage.Dao.StudentDao;
import studentmanage.models.StudentInfo;

/**
 * Servlet implementation class SelectStudentServlet
 */
@WebServlet("/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(UserClassEditServlet.class.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/xml");
         response.setHeader("Cache-Control", "no-cache");
         String classid = request.getParameter("id");
         StudentDao dao=new  StudentDao(); 
         int id=Integer.parseInt(classid);
         ArrayList<StudentInfo> lst= dao.getStudentInfoByClassId(id);        
         //JSON  
         JsonConfig jsonConfig = new JsonConfig();
         jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
		 JSONArray json = JSONArray.fromObject(lst,jsonConfig);  
         String jsonStr = json.toString();
         logger.info(jsonStr);
         PrintWriter out=response.getWriter();
         out.write(jsonStr);
         out.close();
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
