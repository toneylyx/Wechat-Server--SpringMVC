package com.lyx.message;

import java.util.List;

/**
 * ͼ����Ϣbean
 * 
 */
public class NewsMessage extends BaseMessage {

	// <xml>
	// <ToUserName><![CDATA[toUser]]></ToUserName>
	// <FromUserName><![CDATA[fromUser]]></FromUserName>
	// <CreateTime>12345678</CreateTime>
	// <MsgType><![CDATA[news]]></MsgType>
	// <ArticleCount>2</ArticleCount>
	// <Articles>
	// <item>
	// <Title><![CDATA[title1]]></Title>
	// <Description><![CDATA[description1]]></Description>
	// <PicUrl><![CDATA[picurl]]></PicUrl>
	// <Url><![CDATA[url]]></Url>
	// </item>
	// <item>
	// <Title><![CDATA[title]]></Title>
	// <Description><![CDATA[description]]></Description>
	// <PicUrl><![CDATA[picurl]]></PicUrl>
	// <Url><![CDATA[url]]></Url>
	// </item>
	// </Articles>
	// </xml>

	/**
	 * ͼ����Ϣ����������Ϊ10������
	 */
	private int ArticleCount;
	/**
	 * ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10���򽫻�����Ӧ
	 */
	private List<News> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<News> getArticles() {
		return Articles;
	}

	public void setArticles(List<News> articles) {
		Articles = articles;
	}

}
