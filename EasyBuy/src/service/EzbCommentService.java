package service;

import java.util.List;

import entity.EzbComment;

public interface EzbCommentService {
			//添加用户留言
			public int addComment(String ecContent,String ecNickName);
			//添加管理员回复留言
			public int addReply(String ecReply,int ecId);
			//根据ID查询
			public EzbComment checkById(int ecId);
			//删除留言
			public int deleteComment(int ecId);
			//分页查询页数
			public int checkCount();
			//分页查看全部留言
			public List<EzbComment> checkByPage(int pageNo, int pageSize);
			//分页
			public int checkPages(int pageSize);
				
}
