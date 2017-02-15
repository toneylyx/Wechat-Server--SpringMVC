package com.lyx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lyx.utils.CheckUtil;
import com.lyx.utils.MessageUtils;

@Controller
public class WeChatServer {
	//测试号
	public static String APPID = "wx5e6ad647d063049a";
	//测试号
	public static String APPSECRET = "d4763cf21a05d9e8739942ff49be882f";

	private String fileUrl = "http://lyx.ngrok.ngrok.cc/SpringMVC/image/locus.jpg";
	private String musicUrl = "http://lyx.ngrok.ngrok.cc/SpringMVC/music/Seve.mp3";

	@RequestMapping(value = "/wechat", method = RequestMethod.GET)
	public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// APPID = "wxb95a755b43bbf85a";
		// APPSECRET = "87cf99be9db60e02b666359e8b95e8bc";
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		PrintWriter writer = response.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			writer.print(echostr);
		}
		writer.flush();
		writer.close();
	}


	@RequestMapping(value = "/wechat", method = RequestMethod.POST)
	public void doBusiness(HttpServletRequest request, HttpServletResponse response)
			throws IOException, DocumentException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map;
		PrintWriter pw = response.getWriter();
		try {
			map = MessageUtils.xmlToMap(request);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			String msg = null;
			if (msgType.equals(MessageUtils.MESSAGE_TEXT)) {
				// 如果是文本消息，就应该进行回复
				if (content.equals("1")) {
					msg = MessageUtils.createNewsMessage(toUserName, fromUserName, "图文消息介绍", fileUrl, "图片文字描述",
							"www.mi.com");
				} else if (content.equals("2")) {
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, "文本消息");
					msg = msg + MessageUtils.createTextMessage(toUserName, fromUserName, "多条文本消息");
				} else if (content.equals("3")) {
					msg = MessageUtils.createImageMessage(toUserName, fromUserName, "",
							"D:\\workspace\\SpringMVC\\WebContent\\image\\locus.jpg");
				} else if (content.equals("4")) {
					msg = MessageUtils.createMusicMessage(toUserName, fromUserName, "音乐消息", "Seve", musicUrl, musicUrl,
							"D:\\workspace\\SpringMVC\\WebContent\\image\\locus.jpg");
				} else if (content.equals("？") || content.equals("?")) {
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, MessageUtils.getMenuText());
				} else {
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, "测试,您发送的消息是:" + content);
				}

			} else if (msgType.equals(MessageUtils.MESSAGE_IMAGE)) {
				String mediaId = map.get("MediaId");
				msg = MessageUtils.createImageMessage(toUserName, fromUserName, mediaId, "");

			} else if (msgType.equals(MessageUtils.MESSAGE_EVENT)) {
				String event = map.get("Event");

				if (event.equals(MessageUtils.MESSAGE_EVENT_SUBSCRIBE)) {
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, MessageUtils.getMenuText());
				} else if (event.equals(MessageUtils.MESSAGE_CLICK)) {
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, MessageUtils.getMenuText());
				} else if (event.equals(MessageUtils.MESSAGE_VIEW)) {
					// 事件KEY值，设置的跳转URL
					String url = map.get("EventKey");
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, url);
				} else if (event.equals(msgType.equals(MessageUtils.MESSAGE_SCANCODE))) {
					String key = map.get("EventKey");
					msg = MessageUtils.createTextMessage(toUserName, fromUserName, key);
				}
			} else if (msgType.equals(MessageUtils.MESSAGE_LOCATION)) {
				String label = map.get("Label");
				msg = MessageUtils.createTextMessage(toUserName, fromUserName, label);
			} else {
				msg = "success";
			}
			System.out.println(msg);
			pw.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}