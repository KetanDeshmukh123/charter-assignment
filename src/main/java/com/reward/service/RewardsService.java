package com.reward.service;

import java.util.List;

import com.reward.dto.Reward;
import com.reward.entity.Transaction;

public interface RewardsService {
	
	public List<Reward> getrewardpoints(List<Transaction> trans);
	//public List<Reward> getrewardpoints();

}
