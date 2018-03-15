	package entity;

import java.io.Serializable;

public class EzbProduct implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4505818505682931930L;
	private int epId;//商品编号
	private String epName;//商品名称
	private String epDescription;//商品描述
	private double epPrice;//商品单价
	private int epcStock;//商品库存
	private int epcId;//商品一级分类编号
	private int epcChildId;//商品二级分类编号
	private String epFileName;//上传文件名
	private int epDelete;//1为正常商品 2为已删除不显示
	
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
