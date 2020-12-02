Feature: Diposit
This feature allow the client to diposit.

Scenario:
Given a client having balance = 20
When he makes a deposit of 200 on 16-11-2020
And he makes a withdrawal of 100 on 17-11-2020
And request the operation history
Then he would get a list containing those information:

          DATE | AMOUNT  | BALANCE
    16-11-2020 | 200,00  | 220,00
    17-11-2020 | -100,00 | 120,00