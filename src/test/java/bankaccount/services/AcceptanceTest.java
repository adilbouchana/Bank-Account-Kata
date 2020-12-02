package bankaccount.services;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import bankaccount.entity.Account;
import bankaccount.entity.Operation;
import bankaccount.repository.OperationRepository;

@RunWith(MockitoJUnitRunner.class)
public class AcceptanceTest {

	@Mock
	private OperationPrinter operationPrinter;

	@Mock
	private OperationRepository operationRepository;

	@InjectMocks
	private Account account = new Account(operationRepository,operationPrinter);

	@Test
	public void testPrintHistoryOfOperations() {
		account.deposit(1000);
		account.withdrawal(-100);
		account.deposit(500);
		account.seeOperationsHistory();
		List<Operation> operations=operationRepository.getAllOperations();
		verify(operationPrinter).print(operations);
	}

}
