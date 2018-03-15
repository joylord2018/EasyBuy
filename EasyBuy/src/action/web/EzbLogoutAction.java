package action.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EzbUserService;
import serviceImpl.EzbUserServiceImpl;

import entity.EzbShopcar;
import entity.EzbUser;

public class EzbLogoutAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2580317939783484122L;

	/**
	 * Constructor of the object.
	 */
	public EzbLogoutAction() {
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
		EzbUserService esu=new EzbUserServiceImpl();
		EzbUser eu=(EzbUser) request.getSession().getAttribute("eu");
		esu.updateUserLogin(2, eu);
		request.getSession().removeAttribute("eu");
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("userId");
		request.getSession().removeAttribute("admin");
		request.getSession().removeAttribute("sc");
		request.getSession().removeAttribute("linesNum");
		request.getSession().removeAttribute("discount");
		EzbShopcar sc=new EzbShopcar();
		request.getSession().setAttribute("sc", sc);
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
