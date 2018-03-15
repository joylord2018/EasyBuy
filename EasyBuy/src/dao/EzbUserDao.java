package dao;

import java.util.List;

import entity.EzbUser;

public interface EzbUserDao {

	public List<EzbUser> checkByPage(int pageNo,int pageSize);	//��ҳ�鿴ȫ��

	public int checkCount();	//��������

	public int deleteUser(int euDelete,String euUserId);	//ɾ���û�(����delete���ֲ���ʾ��ҳ��)

	public int updateUser(EzbUser user,String euUserId);	//�޸��û�

	public EzbUser checkById(String euUserId);	//����Id��ѯ�û�
	
	public EzbUser findByUsernameAndPwd(String userId,String password); //��½
	
	public int updateUserLogin(int EuLogin,EzbUser user); //����״̬
	
	public int reg(EzbUser user); //ע��
}
