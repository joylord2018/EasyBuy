package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class EzbOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6784141151606677769L;
	private String eoId;//�������
	private String eoUserId;//�û���
	private String eoUserName;//�û���ʵ����
	private String eoUserAddress;//�û���ַ
	private Timestamp eoCreateTime;//��������ʱ��
	private double eoCost;//�����ܽ��
	private int eoStatus;//����״̬ 1����ˣ�2���ͨ����3�����4�����ѷ�����5���ջ�
	public String getEoId() {
		return eoId;
	}
	public void setEoId(String eoId) {
		this.eoId = eoId;
	}
	public String getEoUserId() {
		return eoUserId;
	}
	public void setEoUserId(String eoUserId) {
		this.eoUserId = eoUserId;
	}
	public String getEoUserName() {
		return eoUserName;
	}
	public void setEoUserName(String eoUserName) {
		this.eoUserName = eoUserName;
	}
	public String getEoUserAddress() {
		return eoUserAddress;
	}
	public void setEoUserAddress(String eoUserAddress) {
		this.eoUserAddress = eoUserAddress;
	}
	public Timestamp getEoCreateTime() {
		return eoCreateTime;
	}
	public void setEoCreateTime(Timestamp eoCreateTime) {
		this.eoCreateTime = eoCreateTime;
	}
	public double getEoCost() {
		return eoCost;
	}
	public void setEoCost(double eoCost) {
		this.eoCost = eoCost;
	}
	public int getEoStatus() {
		return eoStatus;
	}
	public void setEoStatus(int eoStatus) {
		this.eoStatus = eoStatus;
	}
	
	public EzbOrder() {
		// TODO Auto-generated constructor stub
	}
	public EzbOrder(String eoId, String eoUserId, String eoUserName,
			String eoUserAddress, Timestamp eoCreateTime, double eoCost,
			int eoStatus) {
		super();
		this.eoId = eoId;
		this.eoUserId = eoUserId;
		this.eoUserName = eoUserName;
		this.eoUserAddress = eoUserAddress;
		this.eoCreateTime = eoCreateTime;
		this.eoCost = eoCost;
		this.eoStatus = eoStatus;
	}
	
}
