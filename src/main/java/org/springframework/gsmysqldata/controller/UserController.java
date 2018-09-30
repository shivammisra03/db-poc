package org.springframework.gsmysqldata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.gsmysqldata.entity.User;
import org.springframework.gsmysqldata.repository.UserRepository;
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
	public String save(@RequestBody User user) {
		userRepository.save(user);
		return "saved";

	}

}
