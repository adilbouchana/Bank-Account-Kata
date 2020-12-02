package bankaccount.services;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import bankaccount.entity.Account;
import bankaccount.entity.Operation;
import bankaccount.repository.OperationRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	@Mock
	private OperationRepository operationRepository;

	@Mock
	private OperationPrinter operationPrinter;

	@InjectMocks
	private Account account = new Account(operationRepository, operationPrinter);

	@Test
	public void testDeposit() {
		account.deposit(1000);
		verify(operationRepository).deposit(1000);
	}

	@Test
	public void testWithdrawal() {
		account.withdrawal(500);
		verify(operationRepository).withdrawal(500);
	}

	@Test
	public void testReturnAllTransactions() {
		account.seeOperationsHistory();
		verify(operationRepository).getAllOperations();
	}

	@Test
	public void testPrintAllTransactions() {
		List<Operation> transactions = new ArrayList<Operation>();
		Mockito.when(operationRepository.getAllOperations()).thenReturn(transactions);
		account.seeOperationsHistory();
		verify(operationPrinter).print(transactions);
	}

}
