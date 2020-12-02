Feature: Withdrawal
This feature allow the client to withraw.

Scenario:
Given a client having balance = 220
When he makes a withdrawal of 100 
Then the balance became 120
And an operation is added with amount = -100