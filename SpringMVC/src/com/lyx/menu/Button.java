package com.lyx.menu;

/**
 * һ���˵�����
 */
public class Button {

	// {
	// "button":[
	// {
	// "type":"click",
	// "name":"���ո���",
	// "key":"V1001_TODAY_MUSIC"
	// },
	// {
	// "name":"�˵�",
	// "sub_button":[
	// {
	// "type":"view",
	// "name":"����",
	// "url":"http://www.soso.com/"
	// },
	// {
	// "type":"view",
	// "name":"��Ƶ",
	// "url":"http://v.qq.com/"
	// },
	// {
	// "type":"click",
	// "name":"��һ������",
	// "key":"V1001_GOOD"
	// }]
	// }]
	// }

	
	public String type;
	
	public String name;
	
	public Button[] sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}

}
