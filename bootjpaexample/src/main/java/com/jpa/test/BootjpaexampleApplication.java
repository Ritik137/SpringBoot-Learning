package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		
//		User user = new User();
//		user.setName("Ritik Anand");
//		user.setCity("Patna");
//		user.setStatus("i am java developer");
//		
//		User user1 = userRepository.save(user);
//		System.out.println(user1);
		
//		create object of users
//		User user = new User();
//		user.setName("manish");
//		user.setCity("Delhi");;
//		user.setStatus("I am a fullstack developer.");
		
//		User user2 = new User();
//		user2.setName("Riya");
//		user2.setCity("Patna");
//		user2.setStatus("I am a human resource enthusist.");
		
//		saving single users...
//		User resultUser = userRepository.save(user2);
//		System.out.println(resultUser);
//		List<User> users = List.of(user,user2);
//		userRepository.saveAll(users);
//		System.out.println("Saved users successfully...");		
//		
		
		
//		Update the user of id 3
//	Optional <User> optional =	userRepository.findById(1);
		
//	User user1 = optional.get();
//	
//	user1.setName("ananya jain");
//	userRepository.save(user1);
//	System.out.println(user1);
// 
	
//	Deleting the user Element...
//	 userRepository.deleteById(1);
//	 System.out.println("deleted");
		
//		find by name
//		List <User> users = userRepository.findByName("riya");
//		users.forEach(e->System.out.println(e));
//	
		List<User> allUser = userRepository.getAllUser();
		allUser.forEach(e->{
			System.out.println(e);
		});
	}

}
