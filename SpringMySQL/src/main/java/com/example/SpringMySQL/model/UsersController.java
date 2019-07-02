package com.example.SpringMySQL.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringMySQL.service.UsersService;


@RestController
public class UsersController {

	
	//Instance of TopicService
		@Autowired
		private UsersService usersService;
		
		//Getting all Data
		@CrossOrigin
		@RequestMapping("/users")
		public List<Users> getAllUsers() {
			return usersService.getAllUsers();
		}
		
		//Getting Specific Data
		@CrossOrigin
		@RequestMapping("/users/{id}")
		public Optional<Users> getTopic(@PathVariable int id) {
			return usersService.getUsers(id);
		}
		
		//Adding Specific Data
		@CrossOrigin
		@RequestMapping(method=RequestMethod.POST, value="/users")
		public void addUsers(@RequestBody Users users) {
			usersService.addUsers(users);
		}
		
		//Updating data
		@CrossOrigin
		@RequestMapping(method=RequestMethod.PUT, value = "/users/{id}")
		public void updateUsers(@RequestBody Users users, @PathVariable int id) {
			usersService.updateUsers(id,users);
		}
		
		//Deleting data
		@CrossOrigin
		@RequestMapping(method=RequestMethod.DELETE, value = "/users/{id}")
		public void deleteUsers(@PathVariable int id) {
			usersService.deleteUsers(id);
		}

}
