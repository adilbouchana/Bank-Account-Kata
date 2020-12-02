Feature: Diposit
This feature allow the client to diposit.

Scenario:
Given a client having balance = 20
When he makes a deposit of 200 
Then The balance became 220
And an operation is added with amount = 200