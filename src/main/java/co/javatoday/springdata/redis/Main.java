package co.javatoday.springdata.redis;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.javatoday.springdata.redis.domain.User;
import co.javatoday.springdata.redis.service.Service;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("springapp.xml");
    	
        @SuppressWarnings("unchecked")
		Service<User> userService = (Service<User>)context.getBean("userService");
        
        User user1 = new User("user1ID", "User 1");
        User user2 = new User("user2ID", "User 2");
        
        System.out.println("==== getting objects from redis ====");
        System.out.println("User is not in redis yet: " + userService.get(user1));
        System.out.println("User is not in redis yet: " + userService.get(user2));
        
        System.out.println("==== putting objects into redis ====");
        userService.put(user1);
        userService.put(user2);
        
        System.out.println("==== getting objects from redis ====");
        System.out.println("User should be in redis yet: " + userService.get(user1));
        System.out.println("User should be in redis yet: " + userService.get(user2));
        
        System.out.println("==== deleting objects from redis ====");
        userService.delete(user1);
        userService.delete(user2);
        
        System.out.println("==== getting objects from redis ====");
        System.out.println("User is not in redis yet: " + userService.get(user1));
        System.out.println("User is not in redis yet: " + userService.get(user2));
		        
    }
}
