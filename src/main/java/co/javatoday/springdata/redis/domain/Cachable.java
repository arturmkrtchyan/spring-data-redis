package co.javatoday.springdata.redis.domain;

import java.io.Serializable;

/**
 * 
 * @author amkrtchyan
 */

public interface Cachable extends Serializable {
	
	public String getKey();
	
	public String getObjectKey();
	
}
