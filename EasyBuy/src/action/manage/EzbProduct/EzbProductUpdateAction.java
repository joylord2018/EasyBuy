package action.manage.EzbProduct;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.EzbProductService;
import serviceImpl.EzbProductServiceImpl;
import entity.EzbProduct;

public class EzbProductUpdateAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085582399920634661L;

	/**
	 * Constructor of the object.
	 */
	public EzbProductUpdateAction() {
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
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EzbProductService proImpl=new EzbProductServiceImpl();
		EzbProduct product=new EzbProduct();
		String path=request.getSession().getServletContext().getRealPath("/pic");
		//获取文件路径并给新文件夹取名
		String epName="";//商品名称
		String epDescription="";//商品描述
		float epPrice=0;//商品单价
		int epcStock=0;//商品库存
		int epcId=0;//商品一级分类编号
		String epFileName="";//上传文件名
		int epDelete=1;//1为正常商品 2为已删除不显示
		File file=new File(path);
		if(!file.exists()){//判断文件是否存在
    		file.mkdir();
    	}
		DiskFileItemFactory df=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(df);
		upload.setFileSizeMax(1024*1024*100);//设置尺寸100M
		try {
			List<FileItem> li=upload.parseRequest(request);
			for(FileItem item:li){
				if(item.isFormField()){//普通字段
					String fieldName=item.getFieldName();//获取组件名
					if(fieldName.equals("productName")){
						epName=item.getString("utf-8");
					}else if(fieldName.equals("productDetail")){
						epDescription=item.getString("utf-8");
					}else if(fieldName.equals("productPrice")){
						epPrice=Float.parseFloat(item.getString("utf-8"));
					}else if(fieldName.equals("productNumber")){
						epcStock=Integer.parseInt(item.getString("utf-8"));
					}else if(fieldName.equals("parentId")){
						epcId=Integer.parseInt(item.getString("utf-8"));
					}
				}else{
					String name=item.getName();//获取上传的文件名
	    			//解决IE浏览器文件名中包含客户端路径的问题
					if(name!=null&&!name.equals("")){//判断非空文件
	    				File temp=new File(name);
	    		 	name=temp.getName();//文件名 
	    			
	    		 	String type=name.substring(name.lastIndexOf(".")+1).toLowerCase();//转小写 文件后缀名
	    		 	name=UUID.randomUUID().toString().replace("-", "")+"."+type;//UUID随机
	    		 	List<String> allowedType=Arrays.asList("jpg","jpeg","gif","png");
	    		 	if(allowedType.contains(type)){
	    		 		String filePath=path+"/"+name;//服务器路径+文件名
	    		 			epFileName=name;
	    		 			File f=new File(filePath);
	    		 			item.write(f);
	    		 		}else{
	    		 			out.print("上传失败");
	    		 		}
	    		 	}
				}
				
			}//循环结束
			product.setEpcId(epcId);
			product.setEpcStock(epcStock);
			product.setEpDelete(epDelete);
			product.setEpDescription(epDescription);
			product.setEpFileName(epFileName);
			product.setEpName(epName);
			product.setEpPrice(epPrice);
			int a=proImpl.addProduct(product);
			if(a!=0){
				request.getRequestDispatcher("manage/manage-result.jsp").forward(request, response);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
