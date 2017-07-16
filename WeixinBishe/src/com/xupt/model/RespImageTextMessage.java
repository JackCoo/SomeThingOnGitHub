package com.xupt.model;

import java.util.List;


public class RespImageTextMessage extends RespBaseMessage {
	
	private String ArticleCount;//图文消息个数
	private List<SignleImageTextMessage> Articles;//图文消息列表
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public List<SignleImageTextMessage> getArticles() {
		return Articles;
	}
	public void setArticles(List<SignleImageTextMessage> articles) {
		Articles = articles;
	}
	@Override
	public String toString() {
		return "RespImageTextMessage [ArticleCount=" + ArticleCount + ", Articles=" + Articles + "]";
	}

}
