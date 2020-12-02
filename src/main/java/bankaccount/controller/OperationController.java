package bankaccount.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankaccount.entity.Operation;
import bankaccount.repository.OperationRepository;
import bankaccount.repository.OperationRepositoryImpl;
import bankaccount.services.OperationPrinter;

@RestController
@RequestMapping("/v1/account/operation")
public class OperationController {

	@Autowired
	private OperationPrinter operationPrinter;
	@Autowired
	private OperationRepository operationRepository ;
	//private OperationRepository operationRepository;
	
	public OperationController(OperationPrinter operationPrinter, OperationRepository operationRepository) {
		this.operationPrinter = operationPrinter;
		this.operationRepository = operationRepository;
	}
	@PostMapping("/deposit")
	public void deposit(@RequestBody double operation) {
		System.out.println(operation);
		operationRepository.deposit(operation);
	}
	@PostMapping("/withdraw")
	public void withdraw(@RequestBody double amount) {
		
		operationRepository.withdrawal(0-amount);
	}
	
	@GetMapping
	public List<Operation> seeOperationsHistory() {
		return operationRepository.getAllOperations();
	}
	
	@GetMapping("/balance")
	public double getBalance () {
		return operationRepository.getBalance();
	}
	
}
