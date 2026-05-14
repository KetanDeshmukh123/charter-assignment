package com.reward.util;

import com.reward.exception.InvalidTransactionException;

public class RewardUtil {

	/*
	 * calculate reward points based on transaction amount
	 */
	public static int calculateRewardPoints(Double amt) {

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
}
