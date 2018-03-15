package action.manage.EzbProduct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EzbProductService;
import serviceImpl.EzbProductServiceImpl;
import util.PageUtil;
import entity.EzbProduct;


public class EzbProductCheckAllAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6362067549567958023L;

	/**
	 * Constructor of the object.
	 */
	public EzbProductCheckAllAction() {
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
		int pageSize=5;//Ã¿Ò³5Ìõ
		int pageNo=1;//Ò³Âë
		if(s_pageNo!=null){
			pageNo=Integer.parseInt(s_pageNo);
		}
		
		if(s_pageSize!=null){
			pageSize=Integer.parseInt(s_pageSize);
		}
		EzbProductService productImpl=new EzbProductServiceImpl();
		PageUtil<EzbProduct> pu=productImpl.getPage(pageNo, pageSize);
		request.setAttribute("pu", pu);
		request.getRequestDispatcher("manage/product.jsp").forward(request, response);
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
