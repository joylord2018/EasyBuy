package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.EzbProductCategoryDao;
import entity.EzbProductCategory;

public class EzbProductCategoryDaoImpl extends BaseDao implements EzbProductCategoryDao {
	//∏∏¿‡ºØ∫œ
	public List<EzbProductCategory> checkByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EzbProductCategory> pLi=new ArrayList<EzbProductCategory>();
		String sql="SELECT * FROM easybuy_product_category where epc_parent_id=-1 LIMIT ?,?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				pLi.add(new EzbProductCategory(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return pLi;
	}
	

	public List<EzbProductCategory> checkByPid(int Pid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		List<EzbProductCategory> cLi=new ArrayList<EzbProductCategory>();
		String sql="SELECT * FROM easybuy_product_category WHERE epc_parent_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, Pid);
			rs=ps.executeQuery();
			while(rs.next()){
				 cLi.add(new EzbProductCategory(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return cLi;
	}


	public int checkCount() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		int count=0;
		String sql="SELECT count(*) FROM easybuy_product_category";
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


	public int updateParCategory(String epcName,int epcparId) {
		String sql="update easybuy_product_category set epc_name=? where epc_id=?";
		return this.executeUpdate(sql, epcName,epcparId);
	}


	public EzbProductCategory checkByEpcId(int Eid) {
		String sql="select * from easybuy_product_category where epc_id=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbProductCategory epc=null;
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, Eid);
			rs=ps.executeQuery();
			if(rs.next()){
				epc=new EzbProductCategory(rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}	
		return epc;
	}


	public int delete(int epcId) {
		String sql="delete from easybuy_product_category where epc_id=?";
		return this.executeUpdate(sql, epcId);
	}


	public int addCategory(String epcName, int epcParId) {
		String sql="insert into easybuy_product_category (epc_name,epc_parent_id) values(?,?)";
		return this.executeUpdate(sql, epcName,epcParId);
	}
}
