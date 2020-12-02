package bankaccount.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bankaccount.repository.OperationRepositoryImpl;

public class OperationRepositoryTest {

	private OperationRepository operationRepository = new OperationRepositoryImpl();

	@Test
	public void testDeposit() {
		operationRepository.deposit(200);
		assertEquals(200, operationRepository.getAllOperations().get(0).getAmount(), 0);
	}

	@Test
	public void testWithdrawal() {
		operationRepository.withdrawal(300);
		assertEquals(300, operationRepository.getAllOperations().get(0).getAmount(), 0);
	}

	@Test 
	public void testReturnAllOperations() {
		operationRepository.deposit(200);
		operationRepository.withdrawal(300);
		assertEquals(2, operationRepository.getAllOperations().size(), 0);
	}

}
