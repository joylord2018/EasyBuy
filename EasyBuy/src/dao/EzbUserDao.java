package dao;

import java.util.List;

import entity.EzbUser;

public interface EzbUserDao {

	public List<EzbUser> checkByPage(int pageNo,int pageSize);	//分页查看全部

	public int checkCount();	//查总条数

	public int deleteUser(int euDelete,String euUserId);	//删除用户(更改delete数字不显示在页面)

	public int updateUser(EzbUser user,String euUserId);	//修改用户

	public EzbUser checkById(String euUserId);	//根据Id查询用户
	
	public EzbUser findByUsernameAndPwd(String userId,String password); //登陆
	
	public int updateUserLogin(int EuLogin,EzbUser user); //更新状态
	
	public int reg(EzbUser user); //注册
}
