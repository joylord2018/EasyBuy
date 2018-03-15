package service;

import java.util.List;
import java.util.Map;

import entity.EzbOrder;
import entity.EzbShopcar;
import entity.OrderAll;

public interface EzbOrderService {
	
	public List<OrderAll> checkAll(String eoId);
	
	public int checkPages(int pageSize);
	
	public int checkCount();
	
	public List<EzbOrder> checkOreder(int pageNo,int pageSize,String eoId,String eoUserId);

	public Map<EzbOrder,List<OrderAll>> checkAllMap(int pageNo,int pageSize,String eoId,String eoUserId);

	public int updateOrder(int eoStatus,String eoId);
	
	public int addOrder(EzbOrder eo,EzbShopcar esc);
	
	public EzbOrder checkById(String eoId);
}
