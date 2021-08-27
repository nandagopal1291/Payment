package com.example.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction findAllById(String transactionid);
}