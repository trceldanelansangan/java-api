package com.example.SpringMySQL.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMySQL.model.Users;
import com.example.SpringMySQL.model.UsersRepository;


@Service
public class UsersService {

	
	@Autowired
	UsersRepository usersRepository;
	
	//Method for getting all user
	public List<Users> getAllUsers(){
		//return topics;
		
		//Using CrudRepository at TopicRepository Interface
		List<Users> users = new ArrayList<Users>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}
		
	//Method for getting specific user
	public Optional<Users> getUsers(int id) {
		//return topics.stream().filter(t -> t.getId() == (id)).findFirst().get();
			
		//Using CrudRepository at TopicRepository Interface
		return usersRepository.findById(id);	
	}
	
	//Method for adding new user
	public void addUsers(Users users) {
		usersRepository.save(users);
	}
	
	//Method for updating user
	public void updateUsers(int id, Users users) {
		usersRepository.save(users);
	}

	//Method for deleting user
	public void deleteUsers(int id) {
		usersRepository.deleteById(id);
	}
}
