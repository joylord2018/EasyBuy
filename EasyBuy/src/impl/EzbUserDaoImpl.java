package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.EzbUserDao;
import entity.EzbUser;

public class EzbUserDaoImpl extends BaseDao implements EzbUserDao{

	public List<EzbUser> checkByPage(int pageNo, int pageSize) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbUser user=new EzbUser();
		List<EzbUser> userLi=new ArrayList<EzbUser>();
		String sql="SELECT * FROM easybuy_user where eu_delete=1 LIMIT ?,?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				user=new EzbUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getInt(10),rs.getInt(11),rs.getInt(12));
				userLi.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return userLi;
	}

	public int checkCount() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql="select count(*) from easybuy_user";
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

	public int deleteUser(int euDelete,String euUserId) {
		String sql="update easybuy_user set eu_delete=? where eu_user_id=?";
		return this.executeUpdate(sql, euDelete,euUserId);
	}

	public int updateUser(EzbUser user,String euUserId) {
		String sql="UPDATE easybuy_user SET eu_user_id=?,eu_user_name=?,eu_password=?,eu_sex=?,eu_birthday=?,eu_Mobile=?,eu_address=? WHERE eu_user_id=?";
		return this.executeUpdate(sql, user.getEuUserId(),user.getEuUserName(),user.getEuPassword(),user.getSex(),user.getEuBirthday(),user.getEuMobile(),user.getEuAddress(),euUserId);
	}

	public EzbUser checkById(String euUserId) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbUser user=null;
		String sql="select * from easybuy_user where eu_user_id=?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, euUserId);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new EzbUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getInt(10),rs.getInt(11),rs.getInt(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return user;
	}

	public EzbUser findByUsernameAndPwd(String userId, String password) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=this.getConnection();
		EzbUser euser=null;
		try {
			ps=con.prepareStatement("select * from easybuy_user where eu_user_id=? and eu_password=?");
			ps.setString(1, userId);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				euser=new EzbUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getInt(10),rs.getInt(11),rs.getInt(12));
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}		
		return euser;
	}

	public int updateUserLogin(int EuLogin,EzbUser user) {
		String sql="UPDATE easybuy_user SET eu_login=? WHERE eu_user_id=?";
		return this.executeUpdate(sql,EuLogin,user.getEuUserId());
	}

	public int reg(EzbUser user) {
		String sql="insert into easybuy_user (eu_user_id,eu_user_name,eu_password,eu_sex,eu_birthday,eu_identity_code,eu_email,eu_mobile,eu_address,eu_login,eu_status,eu_delete) values (?,?,?,?,?,?,?,?,?,2,1,1)";
		Object[]params={user.getEuUserId(),user.getEuUserName(),user.getEuPassword(),user.getSex(),user.getEuBirthday(),user.getEuIdentityCode(),user.getEuEmail(),user.getEuMobile(),user.getEuAddress()};
		return this.executeUpdate(sql, params);
	}
}
