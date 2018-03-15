package action.manage.EzbProduct;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbProduct;
import entity.EzbProductCategory;

import service.EzbProductCategoryService;
import service.EzbProductService;
import serviceImpl.EzbProductCategoryServiceImpl;
import serviceImpl.EzbProductServiceImpl;

public class EzbProductGetIdAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3174452856250622078L;

	/**
	 * Constructor of the object.
	 */
	public EzbProductGetIdAction() {
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
		EzbProductService proImpl=new EzbProductServiceImpl();
		EzbProductCategoryService catImpl=new EzbProductCategoryServiceImpl();
		Map<EzbProductCategory, List<EzbProductCategory>> map=new LinkedHashMap<EzbProductCategory, List<EzbProductCategory>>();
		int epId=Integer.parseInt(request.getParameter("epId"));
    	int pageSize=3;//每页显示3条数据
    	int pageNo=1;//页码
		map=catImpl.checkAll(pageNo, pageSize);
		request.setAttribute("map", map);
		EzbProduct pro=proImpl.checkById(epId);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("manage/product-modify.jsp").forward(request, response);
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
