package com.lyx.message;

/**
 * ͼ����Ϣ��Ŀ
 */
public class News {

	// <item>
	// <Title><![CDATA[title1]]></Title>
	// <Description><![CDATA[description1]]></Description>
	// <PicUrl><![CDATA[picurl]]></PicUrl>
	// <Url><![CDATA[url]]></Url>
	// </item>
	/**
	 * ͼ����Ϣ����
	 */
	private String Title;
	/**
	 * ͼ����Ϣ����
	 */
	private String Description;
	/**
	 * ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ360*200��Сͼ200*200
	 */
	private String PicUrl;
	/**
	 * ���ͼ����Ϣ��ת����
	 */
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
