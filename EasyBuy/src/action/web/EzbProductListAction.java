package action.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbProduct;
import entity.EzbShopcar;

import service.EzbProductService;
import serviceImpl.EzbProductServiceImpl;
import util.PageUtil;

public class EzbProductListAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5051383066552052260L;

	/**
	 * Constructor of the object.
	 */
	public EzbProductListAction() {
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
		String s_pageNo=request.getParameter("pageNo");
		String s_pageSize=request.getParameter("pageSize");
		int epcId=Integer.parseInt(request.getParameter("epcId"));
		int pageSize=5;//Ã¿Ò³5Ìõ
		int pageNo=1;//Ò³Âë
		if(s_pageNo!=null){
			pageNo=Integer.parseInt(s_pageNo);
		}
		
		if(s_pageSize!=null){
			pageSize=Integer.parseInt(s_pageSize);
		}

		EzbProductService eps=new EzbProductServiceImpl();
		List<EzbProduct> eplist=eps.CheckByEpcId(epcId);
		PageUtil<EzbProduct> pu=eps.getPage(pageNo, pageSize);
		request.setAttribute("pu", pu);
		EzbShopcar esc=(EzbShopcar) request.getSession().getAttribute("sc");
		int linesNum=esc.getShoplist().size();
		request.getSession().setAttribute("linesNum",linesNum);
		if(!eplist.equals("")){
			request.setAttribute("eplist", eplist);
			request.getRequestDispatcher("product-list.jsp").forward(request, response);	
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
