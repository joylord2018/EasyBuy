package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.BaseDao;
import dao.EzbCommentDao;
import entity.EzbComment;

public class EzbCommentDaoImpl extends BaseDao implements EzbCommentDao {

	public int addComment(String ecContent, String ecNickName) {
		String sql="insert into easybuy_comment (ec_content,ec_create_time,ec_nick_name) values(?,now(),?)";
		return this.executeUpdate(sql, ecContent,ecNickName);
	}

	public int addReply(String ecReply,int ecId) {
		String sql="update  easybuy_comment set ec_reply=?,ec_reply_time=now() where ec_id=?";
		return this.executeUpdate(sql, ecReply,ecId);
	}

	public int deleteComment(int ecId) {
		String sql="delete from easybuy_comment where ec_id=?";
		return this.executeUpdate(sql, ecId);
	}

	public int checkCount() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql="select count(*) from easybuy_comment";
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

	public List<EzbComment> checkByPage(int pageNo, int pageSize) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbComment comments=new EzbComment();
		List<EzbComment> commentLi=new ArrayList<EzbComment>();
		String sql="SELECT * FROM easybuy_comment ORDER BY ec_create_time DESC LIMIT ?,?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				comments=new EzbComment(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6));
				commentLi.add(comments);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return commentLi;
	}

	public EzbComment checkById(int ecId) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbComment comment=new EzbComment();
		comment=null;
		String sql="select * from easybuy_comment where ec_id=?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,ecId);
			rs=ps.executeQuery();
			if(rs.next()){
				comment=new EzbComment(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return comment;
	}
}
