package action.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbShopcar;

public class EzbShopCarDeleteAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -471625780798417011L;

	/**
	 * Constructor of the object.
	 */
	public EzbShopCarDeleteAction() {
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
		int epId=Integer.parseInt(request.getParameter("epId"));
		EzbShopcar esc=(EzbShopcar) request.getSession().getAttribute("sc");
		if(esc==null){
			esc=new EzbShopcar();
			request.getSession().setAttribute("sc", esc);
		}
		int linesNum=esc.getShoplist().size();
		request.getSession().setAttribute("linesNum",linesNum);
		esc.delete(epId);
		response.sendRedirect("shopping.jsp");
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
