package service;
import entity.EzbOrder;
import entity.EzbShopLine;

public interface EzbOrderDetailService {
	public int addOrderDetail(EzbOrder eo,EzbShopLine esl);
}
