package dao;
import entity.EzbOrder;
import entity.EzbShopLine;

public interface EzbOrderDetailDao {
	public int addOrderDetail(EzbOrder eo,EzbShopLine esl);
}
