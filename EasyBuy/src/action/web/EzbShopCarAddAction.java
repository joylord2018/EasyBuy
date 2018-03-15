package action.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbProduct;
import entity.EzbShopLine;
import entity.EzbShopcar;

import service.EzbProductService;
import serviceImpl.EzbProductServiceImpl;

public class EzbShopCarAddAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4247636860710933685L;

	/**
	 * Constructor of the object.
	 */
	public EzbShopCarAddAction() {
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
		int epId=Integer.parseInt(request.getParameter("epId"));
		EzbProductService eps=new EzbProductServiceImpl();
		EzbProduct ep=eps.checkById(epId);
		EzbShopLine esl=new EzbShopLine();
		esl.setAmount(1);
		esl.setProduct(ep);
		EzbShopcar esc=(EzbShopcar)request.getSession().getAttribute("sc");
		if(esc==null){
			esc=new EzbShopcar();
			request.getSession().setAttribute("sc",esc);
		}
		int linesNum=esc.getShoplist().size();
		request.getSession().setAttribute("linesNum",linesNum);
		esc.add(esl);
		PrintWriter out=response.getWriter();
		out.print(1);
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
		String zzz=request.getParameter("zzz");
		if(zzz==null){
			int epId=Integer.parseInt(request.getParameter("epId"));
			EzbProductService eps=new EzbProductServiceImpl();
			EzbProduct ep=eps.checkById(epId);
			EzbShopLine esl=new EzbShopLine();
			esl.setAmount(1);
			esl.setProduct(ep);
			EzbShopcar esc=(EzbShopcar)request.getSession().getAttribute("sc");
			if(esc==null){
				esc=new EzbShopcar();
				request.getSession().setAttribute("sc",esc);
			}
			int linesNum=esc.getShoplist().size();
			request.getSession().setAttribute("linesNum",linesNum);
			esc.add(esl);
		}
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
