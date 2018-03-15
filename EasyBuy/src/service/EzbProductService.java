package service;

import java.util.List;

import util.PageUtil;
import entity.EzbProduct;

public interface EzbProductService {
		
		public PageUtil<EzbProduct> getPage(int pageNo,int pageSize);
		
		public int addProduct(EzbProduct product);
	
		public int updateProduct(EzbProduct product,int epId);
		//删除(delete为2)
		public int deleteProduct(int epId);
		//按照商品Id查询
		public EzbProduct checkById(int epId);
		
		public List<EzbProduct> nearCheck(String str);//最近浏览
		
		public List<EzbProduct> CheckByEpcId(int epcId);
}
