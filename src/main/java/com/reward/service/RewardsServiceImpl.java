package com.reward.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.dto.Reward;
import com.reward.entity.Transaction;
import com.reward.exception.InvalidTransactionException;
import com.reward.repository.TransactionRepository;

@Service
public class RewardsServiceImpl implements RewardsService {

	@Autowired
	TransactionRepository repo;

	@Override
	public List<Reward> getrewardpoints(List<Transaction> transList) {

		Map<String, Map<String, Integer>> customerMonthlyRewards = new HashMap<>();
		Map<String, Integer> customerTotalRewards = new HashMap<>();

		for (Transaction trans : transList) {

			String custId = trans.getCustId();
			String month = trans.getDate().getMonth().toString();

			int points = this.calculaterewardpoints(trans.getAmount());

			customerMonthlyRewards.putIfAbsent(custId, new HashMap<>());
			customerTotalRewards.putIfAbsent(custId, 0);

			Map<String, Integer> monthlyPoints = customerMonthlyRewards.get(custId);

			monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0) + points);

			customerTotalRewards.put(custId, customerTotalRewards.get(custId) + points);

		}

		List<Reward> rewardlist = new ArrayList<>();

		for (String customerId : customerMonthlyRewards.keySet()) {
			Reward reward = new Reward();
			reward.setCustId(customerId);
			reward.setTotalRewardPoints(customerTotalRewards.get(customerId));
			reward.setMonthlyRewardPoints(customerMonthlyRewards.get(customerId));
			rewardlist.add(reward);

		}

		return rewardlist;
	}

	private int calculaterewardpoints(Double amt) {

		if (amt < 0) {
			throw new InvalidTransactionException("Transaction is Invalid as transaction amount is negative");
		}
		int reward_points = 0;

		if (amt > 100) {
			reward_points = (int) ((amt - 100) * 2 + 50);
		} else {
			reward_points = (int) (amt - 50);
		}
		return reward_points;
	}

	@Override
	public List<Transaction> getTransactionList() {

		return repo.findAll();
	}

}
