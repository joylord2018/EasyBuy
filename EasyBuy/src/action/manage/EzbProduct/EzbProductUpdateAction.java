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
		//��ȡ�ļ�·���������ļ���ȡ��
		String epName="";//��Ʒ����
		String epDescription="";//��Ʒ����
		float epPrice=0;//��Ʒ����
		int epcStock=0;//��Ʒ���
		int epcId=0;//��Ʒһ��������
		String epFileName="";//�ϴ��ļ���
		int epDelete=1;//1Ϊ������Ʒ 2Ϊ��ɾ������ʾ
		File file=new File(path);
		if(!file.exists()){//�ж��ļ��Ƿ����
    		file.mkdir();
    	}
		DiskFileItemFactory df=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(df);
		upload.setFileSizeMax(1024*1024*100);//���óߴ�100M
		try {
			List<FileItem> li=upload.parseRequest(request);
			for(FileItem item:li){
				if(item.isFormField()){//��ͨ�ֶ�
					String fieldName=item.getFieldName();//��ȡ�����
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
					String name=item.getName();//��ȡ�ϴ����ļ���
	    			//���IE������ļ����а����ͻ���·��������
					if(name!=null&&!name.equals("")){//�жϷǿ��ļ�
	    				File temp=new File(name);
	    		 	name=temp.getName();//�ļ��� 
	    			
	    		 	String type=name.substring(name.lastIndexOf(".")+1).toLowerCase();//תСд �ļ���׺��
	    		 	name=UUID.randomUUID().toString().replace("-", "")+"."+type;//UUID���
	    		 	List<String> allowedType=Arrays.asList("jpg","jpeg","gif","png");
	    		 	if(allowedType.contains(type)){
	    		 		String filePath=path+"/"+name;//������·��+�ļ���
	    		 			epFileName=name;
	    		 			File f=new File(filePath);
	    		 			item.write(f);
	    		 		}else{
	    		 			out.print("�ϴ�ʧ��");
	    		 		}
	    		 	}
				}
				
			}//ѭ������
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
