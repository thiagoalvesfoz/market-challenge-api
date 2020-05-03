package com.market.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.challenge.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
