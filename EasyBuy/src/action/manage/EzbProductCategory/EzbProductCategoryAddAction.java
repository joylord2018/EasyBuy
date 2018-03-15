package action.manage.EzbProductCategory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EzbProductCategoryService;
import serviceImpl.EzbProductCategoryServiceImpl;

public class EzbProductCategoryAddAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6505658727912382896L;

	/**
	 * Constructor of the object.
	 */
	public EzbProductCategoryAddAction() {
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
		EzbProductCategoryService epcs=new EzbProductCategoryServiceImpl();
		int epc=0;
		String epcName=request.getParameter("epcName");
		int epcParId=Integer.parseInt(request.getParameter("parentId"));
		if(epcParId==0){
			epcParId=-1;
			epc=epcs.addCategory(epcName, epcParId);
		}else{
			epc=epcs.addCategory(epcName, epcParId);
		}
		if(epc!=0){
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
