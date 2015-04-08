package mongospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		userParam.setUserId("test111");
		userParam.setUserName("test111");
		mongoService.insert(userParam);
		//Users us = mongoService.getUser(userParam);
		//System.out.println(us.getUserName());
		return "/howto";
	}

}
