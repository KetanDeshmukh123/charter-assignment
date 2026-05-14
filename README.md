# charter-assignment

# Problem Statement
 A retailer offers a reward program to its customers, awarding points based on each recorded purchase

 A customer recievec 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction

# Example 
 - $120 purchase
   -> (20 * 2) + (50 * 1) = 90 points
 

# Project Structure
Src
├───main
│   ├───java
│   │   └───com
│   │       └───reward
│   │           │   CharterCustomerRewardsPointApplication.java
│   │           │
│   │           ├───controller
│   │           │       RewardsController.java
│   │           │
│   │           ├───dto
│   │           │       Reward.java
│   │           │
│   │           ├───entity
│   │           │       Customer.java
│   │           │       Transaction.java
│   │           │
│   │           ├───exception
│   │           │       GlobalExceptionHandler.java
│   │           │       InvalidTransactionException.java
│   │           │
│   │           ├───repository
│   │           │       TransactionRepository.java
│   │           │
│   │           └───service
│   │                   RewardsService.java
│   │                   RewardsServiceImpl.java
│   │
│   └───resources
│       │   application.properties
│       │   data.sql
│       │
│       ├───static
│       └───templates
└───test
    └───java
        └───com
            └───reward
                │   CharterEmployeeGiftCardsApplicationTests.java
                │
                ├───controller
                │       RewardsControllerTest.java
                │
                ├───integration
                │       RewardsControllerIntegrationTest.java
                │
                └───service
                        RewardsServiceImplTest.java

# Approach
- Transactions are fetch from H2 DB
- Data is dynamically grouped by:
    - Customer Id
    - month
- Buisness logic to calculate reward points is separated in utility class
- Server side validation is implemented to validate each transaction

# API Information
 1. Fetch transaction list from DB and return reward point details for each customer
     Request:
       GET /rewards/calculate-reward-points
     Response:
       [
         {
           "custId": "cust1",
            "monthlyRewardPoints": {
                "MAY": 26,
                 "APRIL": 110
             },
             "totalRewardPoints": 136
          },
  
       ]

   2 . calculate reward points for each customer from a given transaction list
       Request:
          POST /rewards/calculate-reward-points
       Response:
       [
         {
           "custId": "cust1",
            "monthlyRewardPoints": {
                "MAY": 26,
                 "APRIL": 110
             },
             "totalRewardPoints": 136
          },
  
       ]
