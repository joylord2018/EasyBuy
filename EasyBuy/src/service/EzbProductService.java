package service;

import java.util.List;

import util.PageUtil;
import entity.EzbProduct;

public interface EzbProductService {
		
		public PageUtil<EzbProduct> getPage(int pageNo,int pageSize);
		
		public int addProduct(EzbProduct product);
	
		public int updateProduct(EzbProduct product,int epId);
		//ɾ��(deleteΪ2)
		public int deleteProduct(int epId);
		//������ƷId��ѯ
		public EzbProduct checkById(int epId);
		
		public List<EzbProduct> nearCheck(String str);//������
		
		public List<EzbProduct> CheckByEpcId(int epcId);
}
