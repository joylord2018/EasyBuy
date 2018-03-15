package entity;
import java.io.Serializable;

public class EzbOrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7433845026212094749L;
	private int eodId;//��Ʒ����������
	private String eoId;//��Ʒ�������
	private int epId;//��Ʒ���
	private int eodQuantity;//�����ܼ���
	private double eodCost;//�����ܽ��
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
	
	public EzbOrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public EzbOrderDetail(int eodId, String eoId, int epId, int eodQuantity,
			double eodCost) {
		super();
		this.eodId = eodId;
		this.eoId = eoId;
		this.epId = epId;
		this.eodQuantity = eodQuantity;
		this.eodCost = eodCost;
	}
	
}
