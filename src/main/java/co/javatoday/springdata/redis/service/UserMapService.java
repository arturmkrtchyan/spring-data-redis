package co.javatoday.springdata.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.stereotype.Service;

import co.javatoday.springdata.redis.domain.Cachable;
import co.javatoday.springdata.redis.domain.User;

/**
 * 
 * 
 * @author amkrtchyan
 */

@Service("userMapService")
public class UserMapService implements co.javatoday.springdata.redis.service.Service<User> {
	
	@Autowired
	DefaultRedisMap<String, Cachable> userRedisMap;
	
	@Override
	public void put(User user) {
		userRedisMap.put(user.getKey(), user);
	}

	@Override
	public void delete(User key) {
		userRedisMap.remove(key.getKey());
	}

	@Override
	public User get(User key) {
		return (User) userRedisMap.get(key.getKey());
	}
}