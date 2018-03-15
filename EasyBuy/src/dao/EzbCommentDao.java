package dao;
import java.util.List;
import entity.EzbComment;

public interface EzbCommentDao {
		
		public int addComment(String ecContent,String ecNickName);//添加用户留言
		
		public int addReply(String ecReply,int ecId);//添加管理员留言
		
		public EzbComment checkById(int ecId);//ID查询
		
		public int deleteComment(int ecId);//删除留言
		
		public int checkCount();//分页查询页数
		
		public List<EzbComment> checkByPage(int pageNo, int pageSize);//分页查看全部
}
