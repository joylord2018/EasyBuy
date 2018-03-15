package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class EzbNews implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8358274129094974051L;
	private int enId;//新闻编号
	private String enTitle;//标题
	private String enContent;//内容
	private Timestamp enCreateTime;//创建时间
	public int getEnId() {
		return enId;
	}
	public void setEnId(int enId) {
		this.enId = enId;
	}
	public String getEnTitle() {
		return enTitle;
	}
	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}
	public String getEnContent() {
		return enContent;
	}
	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}
	public Timestamp getEnCreateTime() {
		return enCreateTime;
	}
	public void setEnCreateTime(Timestamp enCreateTime) {
		this.enCreateTime = enCreateTime;
	}
	public EzbNews(int enId, String enTitle, String enContent,
			Timestamp enCreateTime) {
		super();
		this.enId = enId;
		this.enTitle = enTitle;
		this.enContent = enContent;
		this.enCreateTime = enCreateTime;
	}
	public EzbNews() {
		// TODO Auto-generated constructor stub
	}
}
