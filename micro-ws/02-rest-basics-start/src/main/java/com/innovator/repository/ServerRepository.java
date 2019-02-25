package com.innovator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.innovator.model.Server;

public interface ServerRepository  extends CrudRepository<Server, Long>{
	
	
	@Query(value=" select c.servers from Cluster c where c.clusterId=?1")
	public Iterable<Server> findServersByClusterId(Long clusterId);

}
