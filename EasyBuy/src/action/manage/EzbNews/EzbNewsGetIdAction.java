package action.manage.EzbNews;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbNews;

import service.EzbNewsService;
import serviceImpl.EzbNewsServiceImpl;

public class EzbNewsGetIdAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2180655387309127127L;

	/**
	 * Constructor of the object.
	 */
	
	public EzbNewsGetIdAction() {
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
		EzbNewsService enImpl=new EzbNewsServiceImpl();
		int enId=Integer.parseInt((String) request.getParameter("enId"));
		EzbNews news=enImpl.checkById(enId);
		PrintWriter out = response.getWriter();
		request.setAttribute("enTitle", news.getEnTitle());
		request.setAttribute("enId", news.getEnId());
		request.setAttribute("enContent", news.getEnContent());
		request.getRequestDispatcher("manage/news-modify.jsp").forward(request, response);
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
