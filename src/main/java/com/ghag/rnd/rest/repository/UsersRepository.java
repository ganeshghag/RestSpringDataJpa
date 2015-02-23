package com.ghag.rnd.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ghag.rnd.rest.domain.Users;


@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {

	List<Users> findByUsername(@Param("username") String username);
	


}