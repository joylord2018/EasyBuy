package action.manage.EzbUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.EzbUser;
import service.EzbUserService;
import serviceImpl.EzbUserServiceImpl;
import util.PageUtil;

public class EzbUserCheckAllAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4135309162925075341L;

	/**
	 * Constructor of the object.
	 */
	public EzbUserCheckAllAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String s_pageNo=request.getParameter("pageNo");
		String s_pageSize=request.getParameter("pageSize");
		int pageSize=5;//Ã¿Ò³3Ìõ
		int pageNo=1;//Ò³Âë
		if(s_pageNo!=null){
			pageNo=Integer.parseInt(s_pageNo);
		}
		
		if(s_pageSize!=null){
			pageSize=Integer.parseInt(s_pageSize);
		}
		EzbUserService userImpl=new EzbUserServiceImpl();
		PageUtil<EzbUser> pu=userImpl.getPage(pageNo, pageSize);
		request.setAttribute("pu", pu);
		request.getRequestDispatcher("manage/user.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
