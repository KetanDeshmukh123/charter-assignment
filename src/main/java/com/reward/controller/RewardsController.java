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
	
	
	  @Autowired 
	  TransactionRepository repo;
	 
	
	
	
	@GetMapping("/calculate-reward-points")
	//public List<Reward> getCreditPoints(List<Transaction> trans) {
	public List<Reward> getCreditPoints() {
		List<Transaction> transList = repo.findAll();
         List<Reward> rewardList =service.getrewardpoints(transList);
         //List<Reward> rewardList =service.getrewardpoints();
		
		return rewardList;
	}

}
