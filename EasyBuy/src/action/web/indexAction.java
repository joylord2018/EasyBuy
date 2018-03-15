package action.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbNews;
import entity.EzbProduct;
import entity.EzbProductCategory;
import entity.EzbShopcar;

import service.EzbNewsService;
import service.EzbProductCategoryService;
import service.EzbProductService;
import serviceImpl.EzbNewsServiceImpl;
import serviceImpl.EzbProductCategoryServiceImpl;
import serviceImpl.EzbProductServiceImpl;
import util.PageUtil;

public class indexAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2104586538303186975L;

	/**
	 * Constructor of the object.
	 */
	public indexAction() {
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
		int pageNo=1;
		int pageSize=10;
		//新闻
		EzbNewsService ens=new EzbNewsServiceImpl();
		List<EzbNews>ezlist=ens.checkByPage(pageNo, pageSize);
		request.getSession().setAttribute("ezlist", ezlist);

		//分类
		EzbProductCategoryService epzs=new EzbProductCategoryServiceImpl();
		Map<EzbProductCategory, List<EzbProductCategory>> map=new LinkedHashMap<EzbProductCategory, List<EzbProductCategory>>();
		map=epzs.checkAll(pageNo, pageSize);
		request.getSession().setAttribute("map", map);
		
		//商品
		EzbProductService eps=new EzbProductServiceImpl();
		PageUtil<EzbProduct> pu=eps.getPage(pageNo, pageSize);
		request.getSession().setAttribute("pu", pu);
		
		//时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=new Date();
		String time=sdf.format(dt);
		request.getSession().setAttribute("time", time);
		
		//购物车件数
		EzbShopcar esc=(EzbShopcar) request.getSession().getAttribute("sc");
		int linesNum=esc.getShoplist().size();
		request.getSession().setAttribute("linesNum",linesNum);
		
		//获取cookie
		Cookie [] c=request.getCookies();
		List<EzbProduct> lipro=null;
		if(c!=null){
			for(int i=0;i<c.length;i++){
				if(c[i].getName().equals("like")){
					lipro=eps.nearCheck(c[i].getValue());
				}
			}
		}
		request.getSession().setAttribute("lipro", lipro);
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
