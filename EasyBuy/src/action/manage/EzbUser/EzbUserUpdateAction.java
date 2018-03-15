package action.manage.EzbUser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EzbUserService;
import serviceImpl.EzbUserServiceImpl;

import entity.EzbUser;

public class EzbUserUpdateAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7549940090145785256L;

	/**
	 * Constructor of the object.
	 */
	public EzbUserUpdateAction() {
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
		EzbUser euser=new EzbUser();
		EzbUserService es=new EzbUserServiceImpl();
		String euUserId=request.getParameter("userName");
		euser.setEuUserId(request.getParameter("userName"));
		euser.setEuUserName(request.getParameter("name"));
		euser.setEuPassword(request.getParameter("passWord"));
		euser.setSex(request.getParameter("sex"));
		//date×ª»»
		String birthday=request.getParameter("birthday");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=null;
		try {
			dt = sdf.parse(birthday);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date jsd=new java.sql.Date(dt.getTime());
		euser.setEuBirthday(jsd);
		euser.setEuMobile(request.getParameter("mobile"));
		euser.setEuAddress(request.getParameter("address"));
		int a=es.updateUser(euser, euUserId);
		if(a!=0){
			request.getRequestDispatcher("manage/manage-result.jsp").forward(request, response);
		}
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
