package com.reward.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reward.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
