import mongospring.dao.UserDAO;
import mongospring.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class QueryTest {
	@Autowired
	UserDAO userDaoImpl;
	
	/*@Test
	public void insert(){
		User userParam = new User();
		userParam.setUserId("test222");
		userParam.setUserName("test222");
		userDaoImpl.insert(userParam);
	}
	
	@Test
	public void selectByOne(){
		User userParam = new User();
		userParam.setUserId("test222");
		assertThat("test222",is(userDaoImpl.getUser(userParam).getUserName()));
	}*/
	
	@Test
	public void insert(){
		User userParam = new User();
		userParam.setUserId("test555");
		userParam.setUserName("test555");
		userDaoImpl.insert(userParam);
	}
}
