package com.reward.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reward.controller.RewardsController;
import com.reward.dto.Reward;
import com.reward.entity.Transaction;
import com.reward.service.RewardsService;

@ExtendWith(MockitoExtension.class)
class RewardsControllerTest {

    @Mock
    private RewardsService service;

    @InjectMocks
    private RewardsController controller;

    @Test
    void testGetCreditPoints() {

        Transaction transaction = new Transaction();

        Reward reward = new Reward();
        reward.setCustId("CUST1");
        reward.setTotalRewardPoints(100);

        when(service.getTransactionList())
                .thenReturn(List.of(transaction));

        when(service.getrewardpoints(anyList()))
                .thenReturn(List.of(reward));

        List<Reward> response = controller.getRewardPoints();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals("CUST1",
                response.get(0).getCustId());

        verify(service, times(1))
                .getTransactionList();

        verify(service, times(1))
                .getrewardpoints(anyList());
    }
}