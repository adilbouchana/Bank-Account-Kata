package bankaccount.repository;

import java.util.List;

import bankaccount.entity.Operation;

public interface OperationRepository {

	void deposit(double amount);

	void withdrawal(double amount);

	List<Operation> getAllOperations();
	
	double getBalance();
}
