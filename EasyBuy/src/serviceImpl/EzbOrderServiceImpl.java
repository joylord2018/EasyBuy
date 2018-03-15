package serviceImpl;

import impl.EzbOrderDaoImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import service.EzbOrderService;

import dao.EzbOrderDao;

import entity.EzbOrder;
import entity.EzbOrderDetail;
import entity.EzbShopcar;
import entity.OrderAll;

public class EzbOrderServiceImpl implements EzbOrderService {
private EzbOrderDao eod=new EzbOrderDaoImpl();
	public int checkPages(int pageSize) {
		int count=eod.checkCount();//数据总条数
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}

	public int checkCount() {
		return eod.checkCount();
	}

	public List<EzbOrder> checkOreder(int pageNo,
			int pageSize,String eoId,String eoUserId) {
		return eod.checkOreder(pageNo, pageSize,eoId,eoUserId);
	}

	public Map<EzbOrder, List<OrderAll>> checkAllMap(int pageNo,
			int pageSize,String eoId,String eoUserId) {
		Map<EzbOrder, List<OrderAll>> orMap=new LinkedHashMap<EzbOrder,List<OrderAll>>();
		List<EzbOrder> oLi=eod.checkOreder(pageNo, pageSize, eoId,eoUserId);//订单
		for(EzbOrder o:oLi){
			List<OrderAll> odLi=eod.checkAll(o.getEoId());
			orMap.put(o, odLi);
		}
		return orMap;
	}

	public List<EzbOrderDetail> checkDetail(String eoId) {
		return eod.checkDetail(eoId);
	}

	public List<OrderAll> checkAll(String eoId) {
		return eod.checkAll(eoId);
	}

	public int updateOrder(int eoStatus, String eoId) {
		return eod.updateOrder(eoStatus, eoId);
	}

	public int addOrder(EzbOrder eo,EzbShopcar esc) {
		return eod.addOrder(eo, esc);
	}

	public EzbOrder checkById(String eoId) {
		return eod.checkById(eoId);
	}
}
