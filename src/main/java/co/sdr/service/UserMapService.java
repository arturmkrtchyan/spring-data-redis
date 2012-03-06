package co.sdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.stereotype.Service;

import co.sdr.domain.User;

/**
 * 
 * 
 * @author amkrtchyan
 */

@Service("userMapService")
public class UserMapService implements co.sdr.service.Service<User> {
	
	@Autowired
	RedisTemplate<String, User> redisTemplate;
	
	protected DefaultRedisMap<String, User> getDefaultRedisMap() {
		return new DefaultRedisMap<String, User>(User.OBJECT_KEY, redisTemplate);
	}

	@Override
	public void put(User user) {
		getDefaultRedisMap().put(user.getKey(), user);
	}

	@Override
	public void delete(User key) {
		getDefaultRedisMap().remove(key.getKey());
	}

	@Override
	public User get(User key) {
		return getDefaultRedisMap().get(key.getKey());
	}
}