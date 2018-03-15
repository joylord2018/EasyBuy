package serviceImpl;

import java.util.List;

import impl.EzbProductDaoImpl;
import dao.EzbProductDao;
import entity.EzbProduct;

import service.EzbProductService;
import util.PageUtil;

public class EzbProductServiceImpl implements EzbProductService{
	private EzbProductDao epd=new EzbProductDaoImpl();
	public PageUtil<EzbProduct> getPage(int pageNo, int pageSize) {

		PageUtil<EzbProduct> pu=new PageUtil<EzbProduct>();
		pu.setPageNo(pageNo);
		pu.setPageSize(pageSize);
		pu.setMaxCount(epd.checkCount());
		pu.setList(epd.checkByPage(pageNo, pageSize));
		return pu;
	}
	public int addProduct(EzbProduct product) {
		return epd.addProduct(product);
	}
	public int updateProduct(EzbProduct product, int epId) {
		return epd.updateProduct(product, epId);
	}
	public int deleteProduct(int epId) {
		return epd.deleteProduct(epId);
	}
	public EzbProduct checkById(int epId) {
		return epd.checkById(epId);
	}
	public List<EzbProduct> nearCheck(String str) {
		String[] arr={null,null,null};
		String []sarr=str.split(",");
		for(int i=0;i<sarr.length;i++){
				arr[i]=sarr[i];
		}
		return epd.nearCheck(arr);
	}
	public List<EzbProduct> CheckByEpcId(int epcId) {
		return epd.CheckByEpcId(epcId);
	}
}
