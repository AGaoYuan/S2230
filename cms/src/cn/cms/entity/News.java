package cn.cms.entity;

import java.util.Date;

/**
 * �鼮ʵ����
 * @author 21600
 *
 */
public class News {
	private int id;//�鼮���
	private String title;//�鼮��
	private String author;//�鼮����
	private Date createTime;//��������
	private String content;//�鼮����
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
