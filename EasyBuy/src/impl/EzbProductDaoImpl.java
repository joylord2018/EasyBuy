package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.BaseDao;
import dao.EzbProductDao;
import entity.EzbProduct;

public class EzbProductDaoImpl extends BaseDao implements EzbProductDao{

	public List<EzbProduct> checkByPage(int pageNo, int pageSize) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbProduct product=new EzbProduct();
		List<EzbProduct> productLi=new ArrayList<EzbProduct>();
		String sql="SELECT * FROM easybuy_product LIMIT ?,?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				product=new EzbProduct(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
				productLi.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return productLi;
	}

	public int checkCount() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql="select count(*) from easybuy_product";
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
	public int addProduct(EzbProduct product) {
		String sql="insert into easybuy_product (ep_name,ep_description,ep_price,ep_stock,epc_id,ep_file_name,ep_delete) values (?,?,?,?,?,?,?)";
		Object [] param={product.getEpName(),product.getEpDescription(),product.getEpPrice(),product.getEpcStock(),product.getEpcId(),product.getEpFileName(),product.getEpDelete()};
		return this.executeUpdate(sql,param);
	}

	public int updateProduct(EzbProduct product,int epId) {
		String sql="update easybuy_product set ep_name=?,ep_description=?,ep_price=?,ep_stock=?,ep_file_name=? where ep_id=?";
		Object [] param={product.getEpName(),product.getEpDescription(),product.getEpPrice(),product.getEpcStock(),product.getEpFileName(),epId};
		return this.executeUpdate(sql,param);
	}


	public EzbProduct checkById(int epId) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbProduct ept=null;
		String sql="select * from easybuy_product where ep_id=?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, epId);
			rs=ps.executeQuery();
			if(rs.next()){
				ept=new EzbProduct(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return ept;
	}

	public int deleteProduct(int epId) {
		String sql="update easybuy_product set ep_delete=2 where ep_id=?";
		return this.executeUpdate(sql, epId);
	}

	public List<EzbProduct> nearCheck(String[] str) {
		Connection con=this.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EzbProduct> li=new ArrayList<EzbProduct>();
		try {
			ps=con.prepareStatement("select * from easybuy_product where ep_delete=1 and ep_Id in(?,?,?) order by field(ep_id,?,?,?)");
			ps.setString(1, str[0]);
			ps.setString(2, str[1]);
			ps.setString(3, str[2]);
			ps.setString(4, str[0]);
			ps.setString(5, str[1]);
			ps.setString(6, str[2]);
			rs=ps.executeQuery();
			while(rs.next()){
				EzbProduct ep=new EzbProduct(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
				li.add(ep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}

	public List<EzbProduct> CheckByEpcId(int epcId) {
		Connection con=this.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EzbProduct> li=new ArrayList<EzbProduct>();
		try {
			ps=con.prepareStatement("SELECT * FROM easybuy_product WHERE ep_delete=1 AND epc_id IN (SELECT epc_id  FROM `easybuy_product_category` WHERE epc_id=?)ORDER BY ep_id");
			ps.setInt(1, epcId);
			rs=ps.executeQuery();
			while(rs.next()){
				EzbProduct p=new EzbProduct(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
				li.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return li;
	}
}
