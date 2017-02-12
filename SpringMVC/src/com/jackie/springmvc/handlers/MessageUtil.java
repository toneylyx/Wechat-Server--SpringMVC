package com.jackie.springmvc.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	
	public static String initTextMsg(String ToUserName , String FromUserName ,String Content ) {
		TextMsg msg = new TextMsg();
		msg.setFromUserName(ToUserName);
		msg.setToUserName(FromUserName);
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType(MESSAGE_TEXT);
		msg.setContent(Content);
		return mapToXml(msg);
	}
	
	public static Map<String ,String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException{
		Map<String ,String> map = new HashMap<String ,String>();
		
		SAXReader reader = new SAXReader();
		
		InputStream in = req.getInputStream();
		Document doc = reader.read(in);
		
		Element root = doc.getRootElement();
		List<Element> list =root.elements();
		
		for(Element e : list) {
			map.put(e.getName(), e.getText());
		}
		
		in.close();
		return map;
	}
	
	public static String mapToXml(TextMsg msg) {
		XStream stream = new XStream();
		stream.alias("xml", msg.getClass());
		return stream.toXML(msg);
		
	}

	public static String menuText() {
		StringBuffer sb =new StringBuffer();
		sb.append("欢迎您的关注，请按照以下提示操作：\n \n");
		sb.append("1.自动回复介绍  \n");
		sb.append("2.素材管理介绍  \n");
		sb.append("3.自定义菜单介绍  \n \n");
		sb.append("回复 ？ 显示此帮助菜单");
		return sb.toString();
	}
}
