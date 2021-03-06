package com.ghag.rnd.rest.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ghag.rnd.rest.domain.Person;


@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);
	

	@Override
	public <S extends Person> S save(@Valid S arg0);

}