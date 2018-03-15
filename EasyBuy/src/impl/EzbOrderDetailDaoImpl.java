package impl;
import dao.BaseDao;
import dao.EzbOrderDetailDao;
import entity.EzbOrder;
import entity.EzbShopLine;

public class EzbOrderDetailDaoImpl extends BaseDao implements EzbOrderDetailDao{

	public int addOrderDetail(EzbOrder eo, EzbShopLine esl) {
		String sql="insert into easybuy_order_detail(eo_id,ep_id,eod_quantity,eod_cost) values(?,?,?,?)";
		Object[] params={eo.getEoId(),esl.getProduct().getEpId(),esl.getAmount(),esl.getSubtotal()};
		return this.executeUpdate(sql, params);
	}

}
