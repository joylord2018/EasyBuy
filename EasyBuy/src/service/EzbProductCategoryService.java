package service;

import java.util.List;
import java.util.Map;

import entity.EzbProductCategory;

public interface EzbProductCategoryService {
	public Map<EzbProductCategory,List<EzbProductCategory>> checkAll(int pageNo,int pageSize);
	
	public int checkPages(int pageSize);
	
	public int updateParCategory(String epcName,int epcparId);
	
	public List<EzbProductCategory> checkByPid(int Pid);//子类集合
	
	public EzbProductCategory checkByEpcId(int Eid);
	
	public int delete(int epcId);
	
	public int addCategory(String epcName,int epcParId);
}

