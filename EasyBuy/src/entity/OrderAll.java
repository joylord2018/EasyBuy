package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAll implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2638678958383775192L;
	private int eodId; //商品订单详情编号
	private String eoId; //商品订单编号
	private int epId; //商品编号
	private int eodQuantity; //单个订单件数
	private double eodCost; //单个订单金额
	
	private String eoUserId; //用户id
	private String eoUserName; //用户真实姓名
	private String eoUserAddress; //用户地址
	private Timestamp eoCreateTime; //订单创建时间
	private int eoStatus; //订单状态 1待审核，2审核通过，3配货，4卖家已发货，5已收货
	
	private String epName; //商品名称
	private double epPrice; //商品单价
	private String epFileName; //图片路径
	 
	public int getEodId() {
		return eodId;
	}
	public void setEodId(int eodId) {
		this.eodId = eodId;
	}
	public String getEoId() {
		return eoId;
	}
	public void setEoId(String eoId) {
		this.eoId = eoId;
	}
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public int getEodQuantity() {
		return eodQuantity;
	}
	public void setEodQuantity(int eodQuantity) {
		this.eodQuantity = eodQuantity;
	}
	public double getEodCost() {
		return eodCost;
	}
	public void setEodCost(double eodCost) {
		this.eodCost = eodCost;
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
	public int getEoStatus() {
		return eoStatus;
	}
	public void setEoStatus(int eoStatus) {
		this.eoStatus = eoStatus;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public double getEpPrice() {
		return epPrice;
	}
	public void setEpPrice(double epPrice) {
		this.epPrice = epPrice;
	}
	
	public String getEpFileName() {
		return epFileName;
	}
	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}
	public OrderAll() {
		// TODO Auto-generated constructor stub
	}
	public OrderAll(int eodId, String eoId, int epId, int eodQuantity,
			double eodCost, String eoUserId, String eoUserName,
			String eoUserAddress, Timestamp eoCreateTime, int eoStatus,
			String epName, double epPrice, String epFileName) {
		super();
		this.eodId = eodId;
		this.eoId = eoId;
		this.epId = epId;
		this.eodQuantity = eodQuantity;
		this.eodCost = eodCost;
		this.eoUserId = eoUserId;
		this.eoUserName = eoUserName;
		this.eoUserAddress = eoUserAddress;
		this.eoCreateTime = eoCreateTime;
		this.eoStatus = eoStatus;
		this.epName = epName;
		this.epPrice = epPrice;
		this.epFileName = epFileName;
	}
	
	
	
}
