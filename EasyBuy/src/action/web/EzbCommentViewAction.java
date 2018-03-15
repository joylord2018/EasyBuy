package action.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbComment;

import service.EzbCommentService;
import service.EzbNewsService;
import serviceImpl.EzbCommentServiceImpl;
import serviceImpl.EzbNewsServiceImpl;

public class EzbCommentViewAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478790383380745840L;

	/**
	 * Constructor of the object.
	 */
	public EzbCommentViewAction() {
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
		EzbCommentService ecs =new EzbCommentServiceImpl();
		String s_pageNo=request.getParameter("pageNo");
    	String s_pageSize=request.getParameter("pageSize");
    	int pageSize=4;//每页3条数据
    	int countPage=0;//总页数
    	int pageNo=1;//页码
    	if(s_pageNo!=null&&!s_pageNo.equals("")){
    		pageNo=Integer.parseInt(s_pageNo);
    	}
    	if(s_pageSize!=null&&!s_pageSize.equals("")){
    		pageSize=Integer.parseInt(s_pageSize);
    	}
    	EzbNewsService enImpl=new EzbNewsServiceImpl();
    	countPage=enImpl.checkPages(pageSize);
    	if(pageNo<=1){
    		pageNo=1;
    	}
    	if(pageNo>=countPage){
    		pageNo=countPage;
    	}
		List<EzbComment> ezList=ecs.checkByPage(pageNo, pageSize);
		request.setAttribute("ezList", ezList);
		request.setAttribute("pageSize",pageSize);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
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
