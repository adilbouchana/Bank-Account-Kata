package bankaccount.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bankaccount.repository.OperationRepository;
import bankaccount.repository.OperationRepositoryImpl;
import bankaccount.services.OperationPrinter;

public class OperationControllerTest {

	private OperationPrinter operationPrinter;
	private OperationRepository operationRepository = new OperationRepositoryImpl();
	private OperationController operationController;

	@Before
	public void setUp() {
		operationController = new OperationController(operationPrinter, operationRepository);
	}
	@Test
	public void testApiDeposit() {
		operationController.deposit(200);
		assertEquals(200, operationRepository.getAllOperations().get(0).getAmount(), 0);
	}
	@Test
	public void testWithdraw() {
		operationController.withdraw(300);
		assertEquals(-300, operationRepository.getAllOperations().get(0).getAmount(), 0);
	}

	@Test 
	public void testseOperationsHistory() {
		operationController.deposit(200);
		operationController.withdraw(20);
		assertEquals(operationController.seeOperationsHistory().size(), operationRepository.getAllOperations().size(), 0);
	}
	
	@Test 
	public void testseGetBalance() {
		operationController.deposit(200);
		operationController.withdraw(100);
		assertEquals(operationController.getBalance(), (200-100), 0);

	}
}
