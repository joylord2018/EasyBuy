package action.web;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbOrder;
import entity.EzbProduct;
import entity.EzbShopLine;
import entity.EzbShopcar;
import entity.EzbUser;

import service.EzbOrderDetailService;
import service.EzbOrderService;
import service.EzbProductService;
import serviceImpl.EzbOrderDetailServiceImpl;
import serviceImpl.EzbOrderServiceImpl;
import serviceImpl.EzbProductServiceImpl;

public class EzbOrderAddAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7916955791000871295L;

	/**
	 * Constructor of the object.
	 */
	public EzbOrderAddAction() {
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
		EzbOrderService os=new EzbOrderServiceImpl();
		String eoId=UUID.randomUUID().toString().replace("-", "");
		EzbShopcar esc=(EzbShopcar) request.getSession().getAttribute("sc");
		String eoUserAddress=request.getParameter("address");
		EzbUser eu=(EzbUser) request.getSession().getAttribute("eu");
		String eoUserId=(String) request.getSession().getAttribute("userId");
		String discount=(String) request.getSession().getAttribute("discount");
		double eoCost;
		String eoUserName=eu.getEuUserName();
		if(discount!=""){
			eoCost=esc.getTotal()*0.8;	
		}
		else{
			eoCost=esc.getTotal();
		}	
		// 添加订单
		EzbOrder eo=new EzbOrder();
		eo.setEoId(eoId);
		eo.setEoUserId(eoUserId);
		eo.setEoUserName(eoUserName);
		eo.setEoUserAddress(eoUserAddress);
		eo.setEoCost(eoCost);
		os.addOrder(eo, esc);
		
		//添加订单详情
		EzbOrder eor=os.checkById(eoId);
		EzbOrderDetailService eods=new EzbOrderDetailServiceImpl(); 
		EzbProductService eps=new EzbProductServiceImpl();
		List<EzbShopLine> esli=esc.getLines();
		for(EzbShopLine esl:esli){
			int epId=esl.getProduct().getEpId();
			EzbProduct ep=esl.getProduct();
			ep.setEpcStock(esl.getProduct().getEpcStock()-esl.getAmount());
			eps.updateProduct(ep, epId);	
			eods.addOrderDetail(eor, esl);
		}	
		request.getRequestDispatcher("shopping-result.jsp").forward(request, response);	
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
