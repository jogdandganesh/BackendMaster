package com.shopvista.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopvista.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
