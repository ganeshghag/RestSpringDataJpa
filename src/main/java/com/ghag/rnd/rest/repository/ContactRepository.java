package com.ghag.rnd.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ghag.rnd.rest.domain.Contact;


@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

	List<Contact> findByName(@Param("name") String name);
	


}