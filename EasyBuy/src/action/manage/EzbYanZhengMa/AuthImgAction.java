package action.manage.EzbYanZhengMa;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthImgAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3235276771001515453L;
	/**
	 * Constructor of the object.
	 */
	public AuthImgAction() {
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
	private String flag="0123456789";
	private final int len=4;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		
	//1 随机生成验证码字符串
		Random random=new Random(System.currentTimeMillis());
		int l=flag.length();
		String str="";
		for(int i=0;i<len;i++){
			int index=random.nextInt(l);
			char ch=flag.charAt(index);
			str+=ch;
		}
		
	//2 存入session
		request.getSession().setAttribute("auth", str);
		
	//3 绘图	
		int width=100;
		int height=20;
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		Graphics g=image.getGraphics();
		g.setColor(Color.WHITE);
		
		//g.drawRect(0, 0, width, height);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-2, height-2);
		g.setColor(Color.BLUE);
		g.setFont(new Font("黑体",Font.BOLD,20));
		g.drawString(str, 20, 17);
		
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());		
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
