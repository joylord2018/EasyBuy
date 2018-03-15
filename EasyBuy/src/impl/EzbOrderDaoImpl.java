package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.EzbOrderDao;
import dao.EzbProductDao;
import entity.EzbOrder;
import entity.EzbOrderDetail;
import entity.EzbShopcar;
import entity.OrderAll;

public class EzbOrderDaoImpl extends BaseDao implements EzbOrderDao{
	
	private EzbProductDao epd=new EzbProductDaoImpl();

	public List<OrderAll> checkAll(String eoId) {
		List<OrderAll> oLi=new ArrayList<OrderAll>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		String sql="select * from easybuy_order_detail where eo_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, eoId);
			rs=ps.executeQuery();
			while(rs.next()){
				OrderAll order=new OrderAll();
				order.setEodId(rs.getInt(1));
				order.setEpId(rs.getInt(3));
				//单个订单详情中的商品数量
				//订单信息eoId
				order.setEoUserId(this.checkById(rs.getString(2)).getEoUserId());
				order.setEoUserName(this.checkById(rs.getString(2)).getEoUserName());
				order.setEoUserAddress(this.checkById(rs.getString(2)).getEoUserAddress());
				order.setEoCreateTime(this.checkById(rs.getString(2)).getEoCreateTime());
				order.setEoStatus(this.checkById(rs.getString(2)).getEoStatus());//订单状态
				//商品信息
				order.setEpName(epd.checkById(rs.getInt(3)).getEpName());
				order.setEpPrice(epd.checkById(rs.getInt(3)).getEpPrice());
				order.setEpFileName(epd.checkById(rs.getInt(3)).getEpFileName());
				order.setEodQuantity(rs.getInt(4));
				order.setEoId(rs.getString(2));
				oLi.add(order);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return oLi;
	}

	public EzbOrder checkById(String eoId) {
		EzbOrder eo=new EzbOrder();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		String sql="select * from easybuy_order where eo_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, eoId);
			rs=ps.executeQuery();
			if(rs.next()){
				eo=new EzbOrder(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getDouble(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return eo;
	}

	public List<EzbOrderDetail> checkDetail(String eoId) {
		List<EzbOrderDetail> eodLi=new ArrayList<EzbOrderDetail>();
		EzbOrderDetail eod=new EzbOrderDetail();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		String sql="select * from easybuy_order_detail where eo_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, eoId);
			rs=ps.executeQuery();
			while(rs.next()){
				eod=new EzbOrderDetail(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5));
				eodLi.add(eod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return eodLi;
	}

	public List<EzbOrder> checkOreder(int pageNo, int pageSize, String eoId,
			String eoUserId) {
		List<EzbOrder> eoLi=new ArrayList<EzbOrder>();
		EzbOrder eo=new EzbOrder();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		String sql="select * from easybuy_order where eo_id like ? and eo_user_id like ? LIMIT ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(3, (pageNo-1)*pageSize);
			ps.setInt(4, pageSize);
			ps.setString(1, "%"+eoId+"%");
			ps.setString(2, "%"+eoUserId+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				eo=new EzbOrder(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getDouble(6),rs.getInt(7));
				eoLi.add(eo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return eoLi;
	}

	public int checkCount() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql="select count(*) from easybuy_order";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}		
		return count;
	}

	public int updateOrder(int eoStatus, String eoId) {
		String sql="update  easybuy_order set eo_status=? where eo_id=?";
		return this.executeUpdate(sql, eoStatus,eoId);
	}

	public int addOrder(EzbOrder eo,EzbShopcar esc) {
		String sql="insert into easybuy_order(eo_id,eo_user_id,eo_user_name,eo_user_address,eo_create_time,eo_cost,eo_status) values(?,?,?,?,Now(),?,1)";
		Object[] params={eo.getEoId(),eo.getEoUserId(),eo.getEoUserName(),eo.getEoUserAddress(),esc.getTotal()};
		return this.executeUpdate(sql, params);
	}
}