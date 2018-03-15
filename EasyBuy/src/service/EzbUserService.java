package service;


import entity.EzbUser;
import util.PageUtil;

public interface EzbUserService {

	public PageUtil<EzbUser> getPage(int pageNo,int pageSize);

	public EzbUser checkById(String euUserId);

	public int updateUser(EzbUser user,String euUserId);

	public int deleteUser(int euDelete,String euUserId);
	
	public EzbUser findByUsernameAndPwd(String userId,String password); 
	
	public int updateUserLogin(int EuLogin,EzbUser user);
	
	public int reg(EzbUser user);
}
