package com.market.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.challenge.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
