package org.springframework.gsmysqldata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.gsmysqldata.entity.User;
import org.springframework.gsmysqldata.repository.UserRepository;
import org.springframework.gsmysqldata.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/db")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UserResponse save(@RequestBody User user) {
		userRepository.save(user);
		UserResponse response = new UserResponse();
		response.setResult("User Added Successfully");
		return response;

	}

	@GetMapping(value = "/getAllUsers")
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(user -> list.add(user));
		return list;

	}

	@RequestMapping(value = "/namelike", method = RequestMethod.GET)
	public List<User> getUserLike() {
		List<User> nameList = new ArrayList<>();
		userRepository.getFirstNameLike().forEach(name -> nameList.add(name));
		return nameList;

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public UserResponse updateUserEmail(@RequestBody User user) {

		return userRepository.updateUserEmail(String.valueOf(user.getId()), user.getEmail());

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public UserResponse deleteUser(@PathVariable String id) {

		return userRepository.deleteUser(String.valueOf(id));

	}

}
