package com.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reward.dto.Reward;
import com.reward.entity.Transaction;
import com.reward.repository.TransactionRepository;
import com.reward.service.RewardsService;


/**
 * REST Controller responsible for handling reward point related APIs.
 * 
 * This controller exposes endpoints to calculate reward points
 * for customers based on their transaction history.
 * 
 * 
 * 
 */
@RestController
@RequestMapping("/rewards")
public class RewardsController {
	
	@Autowired 
	RewardsService service;
	
	
	/**
     * Calculates reward points for all customer transactions.
     * 
     * This API:
     * Fetches all customer transactions
     * Calculates monthly reward points
     * Calculates total reward points
     * Returns reward summary for each customer
     * 
     * Endpoint:
     * GET /rewards/calculate-reward-points
     * 
     * @return List of customer rewards containing:
     *         customer id,
     *         monthly reward points,
     *         total reward points
     */
	@GetMapping("/calculate-reward-points")
	public List<Reward> getRewardPoints() {
		List<Transaction> transList = service.getTransactionList();
		List<Reward> rewardList = service.getrewardpoints(transList);

		return rewardList;
	}

}
