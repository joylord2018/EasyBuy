package action.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbUser;
import entity.MD5;

import service.EzbUserService;
import serviceImpl.EzbUserServiceImpl;

public class EzbRegAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731273336840155878L;

	/**
	 * Constructor of the object.
	 */
	public EzbRegAction() {
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
		doPost(request,response);
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
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EzbUserService eus=new EzbUserServiceImpl();
		EzbUser eu=new EzbUser();
		eu.setEuUserId(request.getParameter("userId"));
		eu.setEuUserName(request.getParameter("userName"));
		String pwd=request.getParameter("password");
		MD5 md5=new MD5(pwd);
		eu.setEuPassword(md5.compute());
		eu.setSex(request.getParameter("sex"));
		eu.setEuIdentityCode(request.getParameter("identityCode"));
		eu.setEuEmail(request.getParameter("email"));
		eu.setEuAddress(request.getParameter("address"));
		eu.setEuMobile(request.getParameter("mobile"));
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
		int e=eus.reg(eu);
		if(e>0){
			request.getRequestDispatcher("reg-result.jsp").forward(request, response);
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
