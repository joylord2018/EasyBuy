package action.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.EzbShopcar;
import entity.EzbUser;
import entity.MD5;

import service.EzbUserService;
import serviceImpl.EzbUserServiceImpl;

public class EzbLoginAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6965341753581925248L;

	/**
	 * Constructor of the object.
	 */
	public EzbLoginAction() {
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
		EzbUserService esu=new EzbUserServiceImpl();
		HttpSession session=request.getSession();
		EzbShopcar esc=(EzbShopcar) request.getSession().getAttribute("sc");
		int linesNum=esc.getShoplist().size();
		request.getSession().setAttribute("linesNum",linesNum);
		String userId=request.getParameter("userId");
		String pwd=request.getParameter("password");
		MD5 md5=new MD5(pwd);
		String password=md5.compute();
		String code=request.getParameter("code");
		String auth=(String) request.getSession().getAttribute("auth");
		EzbUser eu=esu.findByUsernameAndPwd(userId, password);				
		if(auth.equals(code)){
			if(eu!=null){
				int euStatus=eu.getEuStatus();
				String userName=eu.getEuUserName();
				if(euStatus==1){				
					esu.updateUserLogin(1, eu);
					session.setAttribute("userId", userId);
					session.setAttribute("userName",userName);
					session.setAttribute("eu", eu);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else{
					session.setAttribute("admin", "2");
					esu.updateUserLogin(1, eu);
					session.setAttribute("userId", userId);
					session.setAttribute("userName",userName);
					session.setAttribute("eu", eu);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("msg1", "用户名密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(!auth.equals(code)){
			request.setAttribute("msg2", "验证码输出错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
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
