package action.manage.EzbComment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbComment;

import service.EzbCommentService;
import serviceImpl.EzbCommentServiceImpl;

public class EzbCommentGetIdAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7442458141751464194L;

	/**
	 * Constructor of the object.
	 */
	public EzbCommentGetIdAction() {
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
		PrintWriter out = response.getWriter();
		EzbCommentService commentImpl=new EzbCommentServiceImpl();
		int ecId=Integer.parseInt(request.getParameter("ecId"));
		EzbComment comment=commentImpl.checkById(ecId);
		request.setAttribute("ecId", comment.getEcId());
		request.setAttribute("ecContent", comment.getEcContent());
		request.setAttribute("ecReply", comment.getEcReply());
		request.setAttribute("ecNickName", comment.getEcNickName());
		request.getRequestDispatcher("manage/guestbook-modify.jsp").forward(request, response);
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
