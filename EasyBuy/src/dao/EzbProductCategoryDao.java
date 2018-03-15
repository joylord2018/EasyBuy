package dao;

import java.util.List;

import entity.EzbProductCategory;



public interface EzbProductCategoryDao {
		
		public List<EzbProductCategory> checkByPage(int pageNo,int pageSize);//���༯��
		
		public List<EzbProductCategory> checkByPid(int Pid);//���༯��
		
		public int checkCount();//������
		
		public int updateParCategory(String epcName,int epcparId); //�ĸ�������
		
		public EzbProductCategory checkByEpcId(int Eid);
		
		public int delete(int epcId);
		
		public int addCategory(String epcName,int epcParId);
}
