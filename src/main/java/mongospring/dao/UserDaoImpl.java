package mongospring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import mongospring.domain.User;

@Repository
public class UserDaoImpl implements UserDAO {
	@Autowired
	MongoTemplate mongoTemplate;

	private static String COLLECTION_NAME = "users";
	
	public User getUser(User user) {
		Query query = new Query(new Criteria("userId").is(user.getUserId()));
	    return mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
	}

	public User insert(User user) {
		mongoTemplate.insert(user, COLLECTION_NAME);
	    return user;
	}

	public List<User> getUsers() {
		return (List<User>) mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}
	
	public void deleteUser(User user) {
		Query query = new Query(new Criteria("userId").is(user.getUserId()));
	    mongoTemplate.remove(query, COLLECTION_NAME);
	}

	public User updateUser(User user) {
		Query query = new Query(new Criteria("userId").is(user.getUserId()));
	    Update update = new Update();
	    update.set("userName", user.getUserName());
	    mongoTemplate.updateFirst(query, update, COLLECTION_NAME);

	    return user;
	}

}
