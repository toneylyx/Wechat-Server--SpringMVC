package com.jackie.springmvc.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
	
    @RequestMapping(value = "/helloworld" ,method = RequestMethod.GET)
    public void check(HttpServletRequest request,HttpServletResponse response) throws IOException{
       String signature = request.getParameter("signature");
       String timestamp = request.getParameter("timestamp");
       String nonce = request.getParameter("nonce");
       String echostr = request.getParameter("echostr");
       
       PrintWriter writer =response.getWriter();
       if(CheckUtil.checkSignature(signature, timestamp, nonce)) {
    	   writer.print(echostr);
       }
       writer.flush();
       writer.close();
    }
    
    @RequestMapping(value = "/helloworld" ,method = RequestMethod.POST)
    public void doBusiness(HttpServletRequest req,HttpServletResponse response) throws IOException, DocumentException{
    	
    	req.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	Map<String, String> map = MessageUtil.xmlToMap(req); 
    	
    	String toUserName = map.get("ToUserName");
    	String fromUserName = map.get("FromUserName");
    	String msgType = map.get("MsgType");
    	String content = map.get("Content");
    	
    	PrintWriter writer =response.getWriter();
    	String message = null;
    	if(MessageUtil.MESSAGE_TEXT.equals(msgType)) {
    		if("1".equals(content)) {
    			content = "===自动回复介绍===";
    		}
    		else if("2".equals(content)) {
				content = "===素材管理介绍===";
			}
    		else if("3".equals(content)) {
				content = "===自定义菜单介绍===";
			}
    		else if("?".equals(content) || "？".equals(content)) {
				content = MessageUtil.menuText();
			}
    		message = MessageUtil.initTextMsg(toUserName, fromUserName, content);
    	}
    	
    	if(MessageUtil.MESSAGE_EVENT.equals(msgType)) {
    		String event = map.get("Event");
    		if(MessageUtil.MESSAGE_SUBSCRIBE.equals(event)) {
    			message = MessageUtil.initTextMsg(toUserName, fromUserName, MessageUtil.menuText());
    		}
    	}
    	writer.print(message);
    	writer.flush();
        writer.close();
    }
}