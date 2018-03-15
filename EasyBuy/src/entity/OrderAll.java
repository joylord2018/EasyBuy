package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAll implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2638678958383775192L;
	private int eodId; //��Ʒ����������
	private String eoId; //��Ʒ�������
	private int epId; //��Ʒ���
	private int eodQuantity; //������������
	private double eodCost; //�����������
	
	private String eoUserId; //�û�id
	private String eoUserName; //�û���ʵ����
	private String eoUserAddress; //�û���ַ
	private Timestamp eoCreateTime; //��������ʱ��
	private int eoStatus; //����״̬ 1����ˣ�2���ͨ����3�����4�����ѷ�����5���ջ�
	
	private String epName; //��Ʒ����
	private double epPrice; //��Ʒ����
	private String epFileName; //ͼƬ·��
	 
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
