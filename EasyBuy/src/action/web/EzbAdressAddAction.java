package action.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbUser;

import service.EzbUserService;
import serviceImpl.EzbUserServiceImpl;

public class EzbAdressAddAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3394935314843791934L;

	/**
	 * Constructor of the object.
	 */
	public EzbAdressAddAction() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EzbUserService eus=new EzbUserServiceImpl();
		String userId=(String) request.getSession().getAttribute("userId");
		EzbUser login=(EzbUser) request.getSession().getAttribute("eu");
		String address=request.getParameter("address");
		// get×ª»»
		address=new String(address.getBytes("iso-8859-1"),"utf-8");
		login.setEuAddress(login.getEuAddress()+","+address);
		eus.updateUser(login, userId);
		String [] adress=login.getEuAddress().split(",");
		List<String> ad=Arrays.asList(adress);
		request.setAttribute("ad", ad);
		request.getRequestDispatcher("address.jsp").forward(request, response);
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
