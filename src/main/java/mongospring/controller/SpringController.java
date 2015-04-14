package mongospring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.vertx.java.core.json.JsonObject;

import mongospring.dao.UserDAO;
import mongospring.dao.UserDaoImpl;
import mongospring.domain.User;

/**
 * @author Keesun Baik
 */
@Controller
public class SpringController {

	@Autowired
	private UserDAO mongoService;
	
	@RequestMapping("/howto")
	public String start(){
		User userParam = new User();
		userParam.setUserId("test222");
		userParam.setUserName("test111");
		//mongoService.getUser(userParam);
		//Users us = mongoService.getUser(userParam);
		//System.out.println(us.getUserName());
		System.out.println("aa");
		return "/howto";
	}
	
	@RequestMapping("/changeLocale")
	public String start1(HttpServletRequest request,
			 HttpServletResponse response){
		
		HttpSession session = request.getSession();
		String locale = request.getParameter("locale");
		Locale locales = null;
		 
		if (locale.matches("ko")) {
			 locales = Locale.KOREAN;
		} else {
			 locales = Locale.ENGLISH;
		}
			 
		 // 세션에 존재하는 Locale을 새로운 언어로 변경해준다.
		 session.setAttribute(
		 SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locales);
		 String redirectURL = "redirect:" + request.getHeader("referer");
		 return redirectURL;
	}
	
	@RequestMapping(value="/getJsonByMap")
	public @ResponseBody Map<String , Object> getJsonByMap() {
	    Map<String, Object> jsonObject = new HashMap<String, Object>();
	    Map<String, Object> jsonSubObject = null;
	    ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
	         
	    //1번째 데이터
	    jsonSubObject = new HashMap<String, Object>();
	    jsonSubObject.put("idx", 1);
	    jsonSubObject.put("title", "제목입니다");
	    jsonSubObject.put("create_date", new Date());
	    jsonList.add(jsonSubObject);
	    //2번째 데이터
	    jsonSubObject = new HashMap<String, Object>();
	    jsonSubObject.put("idx", 2);
	    jsonSubObject.put("title", "두번째제목입니다");
	    jsonSubObject.put("create_date", new Date());
	    jsonList.add(jsonSubObject);
	         
	    jsonObject.put("success", true);
	    jsonObject.put("total_count", 10);
	    jsonObject.put("result_list", jsonList);
	         
	    return jsonObject; 
	}
}
