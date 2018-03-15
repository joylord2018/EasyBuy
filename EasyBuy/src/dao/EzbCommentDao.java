package dao;
import java.util.List;
import entity.EzbComment;

public interface EzbCommentDao {
		
		public int addComment(String ecContent,String ecNickName);//����û�����
		
		public int addReply(String ecReply,int ecId);//��ӹ���Ա����
		
		public EzbComment checkById(int ecId);//ID��ѯ
		
		public int deleteComment(int ecId);//ɾ������
		
		public int checkCount();//��ҳ��ѯҳ��
		
		public List<EzbComment> checkByPage(int pageNo, int pageSize);//��ҳ�鿴ȫ��
}
