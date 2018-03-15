package dao;

import java.util.List;


import entity.EzbOrder;
import entity.EzbOrderDetail;
import entity.EzbShopcar;
import entity.OrderAll;

public interface EzbOrderDao {
	
	public List<OrderAll> checkAll(String eoId);//查全部信息
	
	public EzbOrder checkById(String eoId);//根据detail中的Id查信息

	public List<EzbOrderDetail> checkDetail(String eoId);
	//查订单号
	public List<EzbOrder> checkOreder(int pageNo,int pageSize,String eoId,String eoUserId);
	
	public int checkCount();//总条数
	
	public int updateOrder(int eoStatus,String eoId);//更新订单状态
	
	public int addOrder(EzbOrder eo,EzbShopcar esc);//添加订单
}
