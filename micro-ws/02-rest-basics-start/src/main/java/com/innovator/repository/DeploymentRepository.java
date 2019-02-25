package com.innovator.repository;

import org.springframework.data.repository.CrudRepository;

import com.innovator.model.Deployment;

public interface DeploymentRepository extends CrudRepository<Deployment, Long> {

}
