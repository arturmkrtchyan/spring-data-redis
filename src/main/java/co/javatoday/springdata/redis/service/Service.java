package co.javatoday.springdata.redis.service;

import co.javatoday.springdata.redis.domain.Cachable;

/**
 * 
 * @author amkrtchyan
 */

public interface Service<V extends Cachable> {

	public void put(V obj);

	public V get(V key);
	
	public void delete(V key);

}