package com.reward.dto;

import java.util.Map;

public class Reward {
	
	private String custId;
	
	private Map<String, Integer> monthlyRewardPoints;
	
	private int totalRewardPoints;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Map<String, Integer> getMonthlyRewardPoints() {
		return monthlyRewardPoints;
	}

	public void setMonthlyRewardPoints(Map<String, Integer> monthlyRewardPoints) {
		this.monthlyRewardPoints = monthlyRewardPoints;
	}

	public int getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(int totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

	@Override
	public String toString() {
		return "Reward [custId=" + custId + ", monthlyRewardPoints=" + monthlyRewardPoints + ", totalRewardPoints="
				+ totalRewardPoints + "]";
	}
	
	
	

	
	
	

}
