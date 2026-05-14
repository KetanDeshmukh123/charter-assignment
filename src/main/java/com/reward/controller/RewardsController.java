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

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	
	@Autowired 
	RewardsService service;
	
	@GetMapping("/calculate-reward-points")
	public List<Reward> getRewardPoints() {
		List<Transaction> transList = service.getTransactionList();
		List<Reward> rewardList = service.getrewardpoints(transList);

		return rewardList;
	}

}
