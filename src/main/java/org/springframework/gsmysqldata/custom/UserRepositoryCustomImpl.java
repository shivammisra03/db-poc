package org.springframework.gsmysqldata.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.gsmysqldata.entity.User;
import org.springframework.gsmysqldata.response.UserResponse;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getFirstNameLike() {
		Query query = entityManager.createNativeQuery("select * from user where name LIKE ?", User.class);
		query.setParameter(1, "s%");
		
		return query.getResultList();

	}

	@Transactional
	@Override
	public UserResponse updateUserEmail(String id, String email) {

		Query query = entityManager.createNativeQuery("update user set email=? where id=?");
		query.setParameter(1, email);
		query.setParameter(2, id);

		query.executeUpdate();
		UserResponse response = new UserResponse();
		response.setResult("Updated");
		return response;
	}

	@Transactional
	@Override
	public UserResponse deleteUser(String id) {

		Query query = entityManager.createNativeQuery("delete from user where id=?");
		query.setParameter(1, id);

		query.executeUpdate();
		UserResponse response = new UserResponse();
		response.setResult("User Deleted");
		return response;
	}

}
