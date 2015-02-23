package com.ghag.rnd.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ghag.rnd.rest.domain.Trackee;


@RepositoryRestResource(collectionResourceRel = "trackee", path = "trackee")
public interface TrackeeRepository extends PagingAndSortingRepository<Trackee, Long> {

	List<Trackee> findByName(@Param("name") String name);
	


}