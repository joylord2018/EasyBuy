package serviceImpl;

import impl.EzbUserDaoImpl;
import dao.EzbUserDao;
import entity.EzbUser;
import service.EzbUserService;
import util.PageUtil;

public class EzbUserServiceImpl implements EzbUserService{
	private EzbUserDao eud=new EzbUserDaoImpl();
	
	public PageUtil<EzbUser> getPage(int pageNo, int pageSize) {
		PageUtil<EzbUser> pu=new PageUtil<EzbUser>();
		pu.setPageNo(pageNo);
		pu.setPageSize(pageSize);
		pu.setMaxCount(eud.checkCount());
		pu.setList(eud.checkByPage(pageNo, pageSize));
		return pu;
	}
	
	public EzbUser checkById(String euUserId) {
		return eud.checkById(euUserId);
	}

	public int updateUser(EzbUser user, String euUserId) {
		return eud.updateUser(user, euUserId);
	}

	public int deleteUser(int euDelete, String euUserId) {
		return eud.deleteUser(euDelete, euUserId);
	}

	public EzbUser findByUsernameAndPwd(String userId, String password) {
		return eud.findByUsernameAndPwd(userId, password);
	}

	public int updateUserLogin(int EuLogin, EzbUser user) {
		return eud.updateUserLogin(EuLogin, user);
	}

	public int reg(EzbUser user) {
		return eud.reg(user);
	}
}
