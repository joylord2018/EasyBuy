package entity;

import java.io.Serializable;

public class EzbProductCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4752376043527538214L;
	private int epcId;//1级分类编号
	private String epcName;//1级分类名称
	private int epcParentId;
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getEpcName() {
		return epcName;
	}
	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}
	public int getEpcParentId() {
		return epcParentId;
	}
	public void setEpcParentId(int epcParentId) {
		this.epcParentId = epcParentId;
	}
	public EzbProductCategory(int epcId, String epcName, int epcParentId) {
		super();
		this.epcId = epcId;
		this.epcName = epcName;
		this.epcParentId = epcParentId;
	}
	public EzbProductCategory() {
		// TODO Auto-generated constructor stub
	}
}
