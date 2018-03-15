package dao;

import java.util.List;

import entity.EzbProduct;

public interface EzbProductDao {
	//��ҳ�鿴ȫ��
	public List<EzbProduct> checkByPage(int pageNo,int pageSize);

	public int checkCount();

	public int addProduct(EzbProduct product);

	public int updateProduct(EzbProduct product,int epId);

	public int deleteProduct(int epId);

	public EzbProduct checkById(int epId);
	
	public List<EzbProduct> nearCheck(String str[]);//������
	
	public List<EzbProduct> CheckByEpcId(int epcId);
}
