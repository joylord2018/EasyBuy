package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class EzbOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6784141151606677769L;
	private String eoId;//订单编号
	private String eoUserId;//用户名
	private String eoUserName;//用户真实姓名
	private String eoUserAddress;//用户地址
	private Timestamp eoCreateTime;//订单创建时间
	private double eoCost;//订单总金额
	private int eoStatus;//订单状态 1待审核，2审核通过，3配货，4卖家已发货，5已收货
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
