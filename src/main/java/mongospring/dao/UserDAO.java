package mongospring.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import mongospring.domain.User;

public interface UserDAO {
	public User getUser(User user);
	
	public User insert(User user);
	
	public List<User> getUsers();
	  
	public void deleteUser(User user);
	
	public User updateUser(User user);
}
