package action.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.EzbProductCategory;

import serviceImpl.EzbProductCategoryServiceImpl;

public class EzbProductCategoryClick extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4923127755264750645L;

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
		response.setContentType("text/json;charset=utf-8");
		int epcId=Integer.parseInt(request.getParameter("epcId"));
		EzbProductCategoryServiceImpl pcs=new EzbProductCategoryServiceImpl();
		List<EzbProductCategory> lizpc=pcs.checkByPid(epcId);
		String json_lizpc=JSON.toJSONString(lizpc);
		PrintWriter out=response.getWriter();
		out.print(json_lizpc);
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
