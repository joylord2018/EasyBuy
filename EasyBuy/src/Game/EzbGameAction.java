package Game;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EzbGameAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4050525767932894930L;

	/**
	 * Constructor of the object.
	 */
	public EzbGameAction() {
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
			String discount=(String) request.getSession().getAttribute("discount");
			int guessNum=0;
			Random random=new Random();
			guessNum=random.nextInt(10);
			if(discount!=null){
				request.setAttribute("msg4", "������һ��8���Ż�ȯ���޷�����ȡ��");
			}else{
				if(request.getParameter("num")!=null && request.getParameter("num")!=""){
					int num=Integer.parseInt(request.getParameter("num"));
					if(guessNum==num){
						request.getSession().setAttribute("discount","1");
						request.setAttribute("msg4", "��ϲ�������8���ۿ�ȯ");
					}else if(guessNum>num){
						request.setAttribute("msg4", "���ź������µ�����С��һ��");	
					}else{
						request.setAttribute("msg4", "���ź������µ����ִ���һ��");
					}	
				}
				else{
					request.setAttribute("msg4", "����Ϊ��");
					request.getRequestDispatcher("game.jsp").forward(request, response);
					return;
				}
			}		
			request.getRequestDispatcher("game.jsp").forward(request, response);
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
