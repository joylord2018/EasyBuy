package action.manage.EzbOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EzbOrderService;
import serviceImpl.EzbOrderServiceImpl;

public class EzbOrderUpdateAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176081893683180084L;

	/**
	 * Constructor of the object.
	 */
	public EzbOrderUpdateAction() {
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
		EzbOrderService orDao=new EzbOrderServiceImpl();
		PrintWriter out = response.getWriter();
		String eoId=request.getParameter("eoId");
		int eoStatus=Integer.parseInt(request.getParameter("eoStatus"));
		int a=orDao.updateOrder(eoStatus, eoId);
		out.print(a);
		List<String> li=Arrays.asList("待审核","审核通过","配货","发货","收货确认");
    	request.setAttribute("li", li);
		request.getRequestDispatcher("manage/order.jsp").forward(request, response);
		out.flush();
		out.close();
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
