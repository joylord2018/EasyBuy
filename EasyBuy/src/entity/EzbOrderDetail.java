package entity;
import java.io.Serializable;

public class EzbOrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7433845026212094749L;
	private int eodId;//商品订单详情编号
	private String eoId;//商品订单编号
	private int epId;//商品编号
	private int eodQuantity;//订单总件数
	private double eodCost;//订单总金额
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
