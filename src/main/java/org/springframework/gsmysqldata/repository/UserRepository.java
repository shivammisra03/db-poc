package org.springframework.gsmysqldata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.gsmysqldata.custom.UserRepositoryCustom;
import org.springframework.gsmysqldata.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>, UserRepositoryCustom {

}
