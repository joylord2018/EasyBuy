package action.manage.EzbOrder;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.EzbOrder;
import entity.OrderAll;

import service.EzbOrderService;
import serviceImpl.EzbOrderServiceImpl;

public class EzbOrderFindAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3961885287862156398L;

	/**
	 * Constructor of the object.
	 */
	public EzbOrderFindAction() {
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
		String eoId=request.getParameter("entityId");
		String eoUserId=request.getParameter("userName");
		EzbOrderService orderDao=new EzbOrderServiceImpl();
		String s_pageNo=request.getParameter("pageNo");
		int pageSize=1;//ÿҳ��ʾ1������
    	int countPage=0;//��ҳ��
    	int pageNo=1;//ҳ��
    	if(s_pageNo!=null){//��ȡ����ʱĬ��Ϊ��һҳ
    		pageNo=Integer.parseInt(s_pageNo);
    	}

    	countPage=orderDao.checkPages(pageSize);
    	if(pageNo<=1){
    		pageNo=1;
    	}
    	if(pageNo>=countPage){
    		pageNo=countPage;
    	}
    	//�жϺ��ٻ�ȡ���ݿ�����
    	Map<EzbOrder, List<OrderAll>> map=new LinkedHashMap<EzbOrder, List<OrderAll>>();
    	map=orderDao.checkAllMap(pageNo, pageSize, eoId, eoUserId);
    	List<String> li=Arrays.asList("�����","���ͨ��","���","����","�ջ�ȷ��");
    	request.setAttribute("li", li);
    	request.setAttribute("map", map);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("countPage", countPage);
		request.getRequestDispatcher("manage/order.jsp").forward(request, response);
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
