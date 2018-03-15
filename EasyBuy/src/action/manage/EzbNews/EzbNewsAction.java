package action.manage.EzbNews;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.EzbNews;
import service.EzbNewsService;
import serviceImpl.EzbNewsServiceImpl;

public class EzbNewsAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3687084906037762882L;

	/**
	 * Constructor of the object.
	 */
	public EzbNewsAction() {
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
		String s_pageNo=request.getParameter("pageNo");
    	String s_pageSize=request.getParameter("pageSize");
    	int pageSize=5;//每页5条数据
    	int countPage=0;//总页数
    	int pageNo=1;//页码
    	if(s_pageNo!=null){
    		pageNo=Integer.parseInt(s_pageNo);
    	}
    	if(s_pageSize!=null){
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
    	//判断后再获取数据库数据
   		List<EzbNews> newsLi=enImpl.checkByPage(pageNo, pageSize);
		request.setAttribute("newsLi", newsLi);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("countPage", countPage);
		request.getRequestDispatcher("manage/news.jsp").forward(request, response);
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
