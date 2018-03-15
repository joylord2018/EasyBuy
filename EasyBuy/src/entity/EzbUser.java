package entity;

import java.io.Serializable;
import java.sql.Date;

public class EzbUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2016536904013112273L;
	private String euUserId;//用户名
	private String euUserName;//用户真实姓名
	private String euPassword;//密码
	private String sex;//性别 T为男 F为女
	private Date euBirthday;//生日
	private String euIdentityCode;//身份证
	private String euEmail;//邮箱
	private String euMobile;//手机
	private String euAddress;//用户地址
	private int euLogin;//是否登陆1是 2否
	private int euStatus;//用户身份1普通用户 2管理员
	private int euDelete;//1正常用户 2已删除用户
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
