package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class EzbComment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2688424609017734511L;
	private int ecId;//评论编号
	private String ecContent;//评论内容
	private Timestamp ecCreateTime;//评论时间
	private String ecReply;//回复评论
	private Timestamp ecReplyTime;//回复时间
	private String ecNickName;//留言用户昵称(用户名)
	
	public int getEcId() {
		return ecId;
	}
	public void setEcId(int ecId) {
		this.ecId = ecId;
	}
	public String getEcContent() {
		return ecContent;
	}
	public void setEcContent(String ecContent) {
		this.ecContent = ecContent;
	}
	public Timestamp getEcCreateTime() {
		return ecCreateTime;
	}
	public void setEcCreateTime(Timestamp ecCreateTime) {
		this.ecCreateTime = ecCreateTime;
	}
	public String getEcReply() {
		return ecReply;
	}
	public void setEcReply(String ecReply) {
		this.ecReply = ecReply;
	}
	public Timestamp getEcReplyTime() {
		return ecReplyTime;
	}
	public void setEcReplyTime(Timestamp ecReplyTime) {
		this.ecReplyTime = ecReplyTime;
	}
	public String getEcNickName() {
		return ecNickName;
	}
	public void setEcNickName(String ecNickName) {
		this.ecNickName = ecNickName;
	}
	public EzbComment(int ecId, String ecContent, Timestamp ecCreateTime,
			String ecReply, Timestamp ecReplyTime, String ecNickName) {
		super();
		this.ecId = ecId;
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReply = ecReply;
		this.ecReplyTime = ecReplyTime;
		this.ecNickName = ecNickName;
	}
	public EzbComment() {
		// TODO Auto-generated constructor stub
	}
}
