package com.innovator.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.innovator.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	List<Order> findByAccountId(String accountId);
}
