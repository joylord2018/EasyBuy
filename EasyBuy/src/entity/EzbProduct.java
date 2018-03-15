	package entity;

import java.io.Serializable;

public class EzbProduct implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4505818505682931930L;
	private int epId;//��Ʒ���
	private String epName;//��Ʒ����
	private String epDescription;//��Ʒ����
	private double epPrice;//��Ʒ����
	private int epcStock;//��Ʒ���
	private int epcId;//��Ʒһ��������
	private int epcChildId;//��Ʒ����������
	private String epFileName;//�ϴ��ļ���
	private int epDelete;//1Ϊ������Ʒ 2Ϊ��ɾ������ʾ
	
	public int getEpDelete() {
		return epDelete;
	}
	public void setEpDelete(int epDelete) {
		this.epDelete = epDelete;
	}
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public String getEpDescription() {
		return epDescription;
	}
	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}
	public double getEpPrice() {
		return epPrice;
	}
	public void setEpPrice(double epPrice) {
		this.epPrice = epPrice;
	}
	public int getEpcStock() {
		return epcStock;
	}
	public void setEpcStock(int epcStock) {
		this.epcStock = epcStock;
	}
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public int getEpcChildId() {
		return epcChildId;
	}
	public void setEpcChildId(int epcChildId) {
		this.epcChildId = epcChildId;
	}
	public String getEpFileName() {
		return epFileName;
	}
	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}
	
	public EzbProduct(int epId, String epName, String epDescription,
			double epPrice, int epcStock, int epcId, int epcChildId,
			String epFileName, int epDelete) {
		super();
		this.epId = epId;
		this.epName = epName;
		this.epDescription = epDescription;
		this.epPrice = epPrice;
		this.epcStock = epcStock;
		this.epcId = epcId;
		this.epcChildId = epcChildId;
		this.epFileName = epFileName;
		this.epDelete = epDelete;
	}
	public EzbProduct() {
		// TODO Auto-generated constructor stub
	}
}
