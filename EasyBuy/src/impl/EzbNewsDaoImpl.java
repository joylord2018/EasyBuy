package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.BaseDao;
import dao.EzbNewsDao;
import entity.EzbNews;

public class EzbNewsDaoImpl extends BaseDao implements EzbNewsDao{

	public int addNews(String enTitle, String enContent) {
		String sql="insert into easybuy_news (en_title,en_content,en_create_time)values(?,?,now())";
		return this.executeUpdate(sql, enTitle,enContent);
	}

	public int deleteNews(int enId) {
		String sql="delete from easybuy_news where en_id=?";
		return this.executeUpdate(sql, enId);
	}

	public int updateNews(String enTitle, String enContent,int enId) {
		String sql="UPDATE easybuy_news SET en_title=?,en_content=?,en_create_time=NOW() WHERE en_id=?";
		return this.executeUpdate(sql, enTitle,enContent,enId);
	}


	public List<EzbNews> checkAll() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbNews news=new EzbNews();
		List<EzbNews> newsLi=new ArrayList<EzbNews>();
		String sql="select * from easybuy_news";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				news=new EzbNews(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
				newsLi.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return newsLi;
	}

	public List<EzbNews> checkByPage(int pageNo, int pageSize) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EzbNews news=new EzbNews();
		List<EzbNews> newsLi=new ArrayList<EzbNews>();
		String sql="SELECT * FROM easybuy_news ORDER BY en_create_time DESC LIMIT ?,?";
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				news=new EzbNews(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
				newsLi.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return newsLi;
	}

	public int checkCount() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql="select count(*) from easybuy_news";
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
	
	public EzbNews checkById(int enId) {
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				EzbNews news=new EzbNews();
				news=null;
				String sql="select * from easybuy_news where en_id=?";
				con=this.getConnection();
				try {
					ps=con.prepareStatement(sql);
					ps.setInt(1,enId);
					rs=ps.executeQuery();
					if(rs.next()){
						news=new EzbNews(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					this.closeAll(con, ps, rs);
				}
				return news;
			}
	}
