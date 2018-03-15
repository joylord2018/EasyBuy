package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import impl.EzbNewsDaoImpl;
import entity.EzbNews;
import service.EzbNewsService;

public class EzbNewsServiceImpl implements EzbNewsService{
	private EzbNewsDaoImpl en=new EzbNewsDaoImpl();
	public int addNews(String enTitle, String enContent) {
		return en.addNews(enTitle, enContent);
	}

	public int deleteNews(int enId) {
		return en.deleteNews(enId);
	}

	public int updateNews(String enTitle, String enContent,int enId) {
		return en.updateNews(enTitle,enContent,enId);
	}

	
	public List<EzbNews> checkByPage(int pageNo, int pageSize) {
		List<EzbNews> newsLi=new ArrayList<EzbNews>();
		newsLi=en.checkByPage(pageNo, pageSize);
		return newsLi;
	}

	public List<EzbNews> checkAll() {
		List<EzbNews> newsLi=new ArrayList<EzbNews>();
		newsLi=en.checkAll();
		return newsLi;
	}

	public int checkCount() {
		return en.checkCount();
	}

	public int checkPages(int pageSize) {
		int count=en.checkCount();//总数据条数
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}

	public EzbNews checkById(int enId) {
		return en.checkById(enId);
	}

}
