package dao;

import java.util.List;


import entity.EzbOrder;
import entity.EzbOrderDetail;
import entity.EzbShopcar;
import entity.OrderAll;

public interface EzbOrderDao {
	
	public List<OrderAll> checkAll(String eoId);//��ȫ����Ϣ
	
	public EzbOrder checkById(String eoId);//����detail�е�Id����Ϣ

	public List<EzbOrderDetail> checkDetail(String eoId);
	//�鶩����
	public List<EzbOrder> checkOreder(int pageNo,int pageSize,String eoId,String eoUserId);
	
	public int checkCount();//������
	
	public int updateOrder(int eoStatus,String eoId);//���¶���״̬
	
	public int addOrder(EzbOrder eo,EzbShopcar esc);//��Ӷ���
}
