package service;

import java.util.List;

import entity.EzbComment;

public interface EzbCommentService {
			//����û�����
			public int addComment(String ecContent,String ecNickName);
			//��ӹ���Ա�ظ�����
			public int addReply(String ecReply,int ecId);
			//����ID��ѯ
			public EzbComment checkById(int ecId);
			//ɾ������
			public int deleteComment(int ecId);
			//��ҳ��ѯҳ��
			public int checkCount();
			//��ҳ�鿴ȫ������
			public List<EzbComment> checkByPage(int pageNo, int pageSize);
			//��ҳ
			public int checkPages(int pageSize);
				
}
