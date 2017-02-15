package com.lyx.menu;

/**
 * 一级菜单数组
 */
public class Button {

	// {
	// "button":[
	// {
	// "type":"click",
	// "name":"今日歌曲",
	// "key":"V1001_TODAY_MUSIC"
	// },
	// {
	// "name":"菜单",
	// "sub_button":[
	// {
	// "type":"view",
	// "name":"搜索",
	// "url":"http://www.soso.com/"
	// },
	// {
	// "type":"view",
	// "name":"视频",
	// "url":"http://v.qq.com/"
	// },
	// {
	// "type":"click",
	// "name":"赞一下我们",
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
