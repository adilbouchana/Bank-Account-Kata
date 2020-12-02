package bankaccount.services;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import bankaccount.entity.Operation;

@RunWith(MockitoJUnitRunner.class)
public class OperationPrinterTest {

	@InjectMocks
	private OperationPrinter operationPrinter = OperationPrinterImpl.getInstance();
	
	@Mock
	private PrintStream printStream;

	private SimpleDateFormat dateFormater=new SimpleDateFormat("dd/MM/yyyy");


	@Test
	public void testPrint() throws ParseException {
		List<Operation> transactions = new ArrayList<Operation>();
		Date dateTransaction1 = dateFormater.parse("01/04/2014");
		Date dateTransaction2 = dateFormater.parse("02/04/2014");
		Date dateTransaction3 = dateFormater.parse("10/04/2014");
		transactions.add(new Operation(dateTransaction1, 1000D));
		transactions.add(new Operation(dateTransaction2, -100D));
		transactions.add(new Operation(dateTransaction3, 500D));
		operationPrinter.print(transactions);
		verify(printStream).println("DATE | AMOUNT | BALANCE");
		verify(printStream).println("10/04/2014 | 500,00 | 1400,00");
		verify(printStream).println("02/04/2014 | -100,00 | 900,00");
		verify(printStream).println("01/04/2014 | 1000,00 | 1000,00");
	}

	@Test
	public void testPrintLine() {
		operationPrinter.printLine("Transcation toString()");
		verify(printStream).println("Transcation toString()");
	}

}
