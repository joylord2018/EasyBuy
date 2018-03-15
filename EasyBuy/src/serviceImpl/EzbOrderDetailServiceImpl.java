package serviceImpl;
import impl.EzbOrderDetailDaoImpl;
import dao.EzbOrderDetailDao;
import entity.EzbOrder;
import entity.EzbShopLine;
import service.EzbOrderDetailService;

public class EzbOrderDetailServiceImpl implements EzbOrderDetailService{
	EzbOrderDetailDao eodd=new EzbOrderDetailDaoImpl();
	public int addOrderDetail(EzbOrder eo, EzbShopLine esl) {
		return eodd.addOrderDetail(eo, esl);
	}

}
