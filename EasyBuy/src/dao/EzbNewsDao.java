package dao;


import java.util.List;

import entity.EzbNews;

public interface EzbNewsDao {
	
	public int addNews(String enTitle,String enContent);

	public int deleteNews(int enId);

	public int updateNews(String enTitle,String enContent,int enId);

	public EzbNews checkById(int enId);

	public List<EzbNews> checkAll();

	public int checkCount();

	public List<EzbNews> checkByPage(int pageNo, int pageSize);
	
}
