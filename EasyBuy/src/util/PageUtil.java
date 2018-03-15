package util;

import java.util.List;

public class PageUtil<T> {
	private int pageNo;// ��ǰҳ��Ĭ��Ϊ1
	private int pageSize;// ÿҳ������
	private int maxCount;// ����������
	private int maxPage;// ���ҳ��
	private int ago;// ��һҳ
	private int after;// ��һҳ
	private List<T> list;// ��װ���ݵ�list����TΪ����

	/**
	 * �õ���ǰҳ
	 * 
	 * @return
	 */

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * ÿҳ��������
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	/**
	 * ���ҳ��
	 * 
	 * @return
	 */
	public int getMaxPage() {
	
		return maxCount % pageSize > 0 ? (maxCount / pageSize) + 1 : maxCount
				/ pageSize < 1 ? 1 : maxCount / pageSize;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * ��һҳ
	 * 
	 * @return
	 */
	public int getAgo() {
		return pageNo - 1 < 1 ? 1 : pageNo - 1;
	}

	public void setAgo(int ago) {
		this.ago = ago;
	}

	/**
	 * ��һҳ
	 * 
	 * @return
	 */
	public int getAfter() {
		return pageNo + 1 > this.getMaxPage() ? this.getMaxPage() : pageNo + 1;
	}

	public void setAfter(int after) {
		this.after = after;
	}

	/**
	 * ��װ��list����
	 * 
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * �ж��Ƿ�����ҳ
	 * 
	 * @return
	 */
	public boolean isFirst() {
		return (this.getPageNo() == 1) ? true : false;
	}

	/**
	 * �ж��Ƿ������һҳ
	 * 
	 * @return
	 */
	public boolean isLast() {
		return (this.getPageNo() == this.getMaxPage()) ? true : false;
	}

	
}