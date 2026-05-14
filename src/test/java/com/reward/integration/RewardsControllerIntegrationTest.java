package com.reward.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.reward.CharterCustomerRewardsPointApplication;
import com.reward.entity.Transaction;
import com.reward.repository.TransactionRepository;


@AutoConfigureMockMvc
@SpringBootTest(classes = CharterCustomerRewardsPointApplication.class)
class RewardsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransactionRepository repo;

    @BeforeEach
    void setup() {

        repo.deleteAll();

        Transaction t1 = new Transaction();
        t1.setCustId("CUST1");
        t1.setAmount(120.0);
        t1.setDate(LocalDate.of(2025, 1, 10));

        Transaction t2 = new Transaction();
        t2.setCustId("CUST1");
        t2.setAmount(80.0);
        t2.setDate(LocalDate.of(2025, 1, 15));

        repo.save(t1);
        repo.save(t2);
    }

    @Test
    void testCalculateRewardPoints() throws Exception {

        mockMvc.perform(
                get("/rewards/calculate-reward-points"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].custId")
                        .value("CUST1"))
                .andExpect(jsonPath("$[0].totalRewardPoints")
                        .value(120))
                .andExpect(jsonPath(
                        "$[0].monthlyRewardPoints.JANUARY")
                        .value(120));
    }
}