package serviceImpl;

import impl.EzbCommentDaoImpl;

import java.util.List;

import entity.EzbComment;
import service.EzbCommentService;

public class EzbCommentServiceImpl implements EzbCommentService{
	private EzbCommentDaoImpl comment=new EzbCommentDaoImpl();
	public int addComment(String ecContent, String ecNickName) {
		return comment.addComment(ecContent, ecNickName);
	}

	public int addReply(String ecReply, int ecId) {
		return comment.addReply(ecReply, ecId);
	}

	public int deleteComment(int ecId) {
		return comment.deleteComment(ecId);
	}

	public int checkCount() {
		return comment.checkCount();
	}

	public List<EzbComment> checkByPage(int pageNo, int pageSize) {
		return comment.checkByPage(pageNo, pageSize);
	}

	public int checkPages(int pageSize) {
		int count=comment.checkCount();
		return count%pageSize==0?count/pageSize:count/pageSize+1;
	
	}

	public EzbComment checkById(int ecId) {
		return comment.checkById(ecId);
	}
}
