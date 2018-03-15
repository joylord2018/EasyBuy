package action.web;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EzbProductCategoryService;
import service.EzbProductService;
import serviceImpl.EzbProductCategoryServiceImpl;
import serviceImpl.EzbProductServiceImpl;
import util.CookieUtil;
import entity.EzbProduct;
import entity.EzbProductCategory;
import entity.EzbShopcar;

public class EzbProductViewAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6310275537335978532L;

	/**
	 * Constructor of the object.
	 */
	public EzbProductViewAction() {
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
		EzbProductService eps=new EzbProductServiceImpl();
		EzbProductCategoryService ecs=new EzbProductCategoryServiceImpl();
		Map<EzbProductCategory, List<EzbProductCategory>> map=new LinkedHashMap<EzbProductCategory, List<EzbProductCategory>>();
		int epId=Integer.parseInt(request.getParameter("epId"));
    	int pageSize=3;  //每页显示3条数据
    	int pageNo=1;  //页码
    	
		Cookie []cookies=request.getCookies();
		Cookie co=null;
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("like")){
					co=c;
					break;
				}
			}
			if(co==null){
				co=new Cookie("like", CookieUtil.getStr(null, epId+""));
			}else{
				String value=co.getValue();
				co=new Cookie("like", CookieUtil.getStr(value, epId+""));
			}
		}
		co.setMaxAge(60*5);//添加商品id到cookie
		response.addCookie(co);
    		
		map=ecs.checkAll(pageNo, pageSize);
		request.setAttribute("map", map);
		EzbProduct pro=eps.checkById(epId);
		request.setAttribute("pro", pro);
		EzbShopcar esc=(EzbShopcar) request.getSession().getAttribute("sc");
		int linesNum=esc.getShoplist().size();
		request.getSession().setAttribute("linesNum",linesNum);
		request.getRequestDispatcher("product-view.jsp").forward(request, response);
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
