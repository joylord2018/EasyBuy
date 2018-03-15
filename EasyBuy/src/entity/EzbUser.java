package entity;

import java.io.Serializable;
import java.sql.Date;

public class EzbUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2016536904013112273L;
	private String euUserId;//�û���
	private String euUserName;//�û���ʵ����
	private String euPassword;//����
	private String sex;//�Ա� TΪ�� FΪŮ
	private Date euBirthday;//����
	private String euIdentityCode;//���֤
	private String euEmail;//����
	private String euMobile;//�ֻ�
	private String euAddress;//�û���ַ
	private int euLogin;//�Ƿ��½1�� 2��
	private int euStatus;//�û����1��ͨ�û� 2����Ա
	private int euDelete;//1�����û� 2��ɾ���û�
	public String getEuUserId() {
		return euUserId;
	}
	public void setEuUserId(String euUserId) {
		this.euUserId = euUserId;
	}
	public String getEuUserName() {
		return euUserName;
	}
	public void setEuUserName(String euUserName) {
		this.euUserName = euUserName;
	}
	public String getEuPassword() {
		return euPassword;
	}
	public void setEuPassword(String euPassword) {
		this.euPassword = euPassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getEuBirthday() {
		return euBirthday;
	}
	public void setEuBirthday(Date euBirthday) {
		this.euBirthday = euBirthday;
	}
	public String getEuIdentityCode() {
		return euIdentityCode;
	}
	public void setEuIdentityCode(String euIdentityCode) {
		this.euIdentityCode = euIdentityCode;
	}
	public String getEuEmail() {
		return euEmail;
	}
	public void setEuEmail(String euEmail) {
		this.euEmail = euEmail;
	}
	public String getEuMobile() {
		return euMobile;
	}
	public void setEuMobile(String euMobile) {
		this.euMobile = euMobile;
	}
	public String getEuAddress() {
		return euAddress;
	}
	public void setEuAddress(String euAddress) {
		this.euAddress = euAddress;
	}
	public int getEuLogin() {
		return euLogin;
	}
	public void setEuLogin(int euLogin) {
		this.euLogin = euLogin;
	}
	public int getEuStatus() {
		return euStatus;
	}
	public void setEuStatus(int euStatus) {
		this.euStatus = euStatus;
	}
	public int getEuDelete() {
		return euDelete;
	}
	public void setEuDelete(int euDelete) {
		this.euDelete = euDelete;
	}
	public EzbUser() {
		// TODO Auto-generated constructor stub
	}
	public EzbUser(String euUserId, String euUserName, String euPassword,
			String sex, Date euBirthday, String euIdentityCode, String euEmail,
			String euMobile, String euAddress, int euLogin, int euStatus,
			int euDelete) {
		super();
		this.euUserId = euUserId;
		this.euUserName = euUserName;
		this.euPassword = euPassword;
		this.sex = sex;
		this.euBirthday = euBirthday;
		this.euIdentityCode = euIdentityCode;
		this.euEmail = euEmail;
		this.euMobile = euMobile;
		this.euAddress = euAddress;
		this.euLogin = euLogin;
		this.euStatus = euStatus;
		this.euDelete = euDelete;
	}
	
	
}
