package bankaccount.entity;

import java.util.List;

import bankaccount.repository.OperationRepository;
import bankaccount.services.OperationPrinter;

public class Account {

	
	private OperationRepository operationRepository;
	private OperationPrinter operationPrinter;

	public Account(OperationRepository operationRepository, OperationPrinter operationPrinter) {
		this.operationPrinter=operationPrinter;
		this.operationRepository=operationRepository;
	}

	public void withdrawal(int amount) {
		operationRepository.withdrawal(amount);
	}

	public void deposit(int amount) {
		operationRepository.deposit(amount);
	}

	public void seeOperationsHistory() {
		List<Operation> operations = operationRepository.getAllOperations();
		operationPrinter.print(operations);
	}

}
