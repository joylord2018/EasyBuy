package dao;

import java.util.List;

import entity.EzbProductCategory;



public interface EzbProductCategoryDao {
		
		public List<EzbProductCategory> checkByPage(int pageNo,int pageSize);//父类集合
		
		public List<EzbProductCategory> checkByPid(int Pid);//子类集合
		
		public int checkCount();//总条数
		
		public int updateParCategory(String epcName,int epcparId); //改父类名称
		
		public EzbProductCategory checkByEpcId(int Eid);
		
		public int delete(int epcId);
		
		public int addCategory(String epcName,int epcParId);
}
