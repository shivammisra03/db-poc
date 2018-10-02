package org.springframework.gsmysqldata.custom;

import java.util.List;

import org.springframework.gsmysqldata.entity.User;
import org.springframework.gsmysqldata.response.UserResponse;

public interface UserRepositoryCustom {

	List<User> getFirstNameLike();

	UserResponse updateUserEmail(String id, String email);

	UserResponse deleteUser(String id);

}
