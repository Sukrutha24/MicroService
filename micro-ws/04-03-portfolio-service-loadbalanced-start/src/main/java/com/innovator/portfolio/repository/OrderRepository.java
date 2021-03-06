package com.innovator.portfolio.repository;


import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.innovator.portfolio.domain.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {

	List<Order> findByAccountId(String accountId);
}
