package serviceImpl;

import impl.EzbProductCategoryDaoImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.EzbProductCategoryDao;
import entity.EzbProductCategory;


import service.EzbProductCategoryService;

public class EzbProductCategoryServiceImpl implements EzbProductCategoryService{
	private EzbProductCategoryDao catDao=new EzbProductCategoryDaoImpl();

	public Map<EzbProductCategory, List<EzbProductCategory>> checkAll(
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Map<EzbProductCategory, List<EzbProductCategory>> map=new LinkedHashMap<EzbProductCategory, List<EzbProductCategory>>();
		//所有父类
		List<EzbProductCategory> pLi=catDao.checkByPage(pageNo, pageSize);
		for(EzbProductCategory p:pLi){
			List<EzbProductCategory> cLi=catDao.checkByPid(p.getEpcId());
			map.put(p, cLi);
		}
		return map;
	}

	public int checkPages(int pageSize) {
		// TODO Auto-generated method stub
		int count=catDao.checkCount();//数据总条数
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	}

	public int updateParCategory(String epcName, int epcparId) {
		return catDao.updateParCategory(epcName, epcparId);
	}

	public List<EzbProductCategory> checkByPid(int Pid) {
		return catDao.checkByPid(Pid);
	}

	public EzbProductCategory checkByEpcId(int Eid) {
		return catDao.checkByEpcId(Eid);
	}

	public int delete(int epcId) {
		return catDao.delete(epcId);
	}

	public int addCategory(String epcName, int epcParId) {
		return catDao.addCategory(epcName, epcParId);
	}

}
