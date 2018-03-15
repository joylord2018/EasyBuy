package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	private final String CLASSNAME="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/easybuy?useEncoding=ture&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
	private final String USERNAME="root";
	private final String PASSWORD="root";
	//创建链接
	public Connection getConnection(){
		Connection con=null;
		try {
			Class.forName(CLASSNAME);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//关闭流
	public void closeAll(Connection con,Statement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//增删改
	public int executeUpdate(String sql,Object...params){
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		con=this.getConnection();
		try {
			ps=con.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject((i+1), params[i]);
			}
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, null);
		}
		return result;
	}
}
