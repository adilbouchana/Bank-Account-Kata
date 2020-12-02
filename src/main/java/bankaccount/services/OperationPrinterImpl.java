package bankaccount.services;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import bankaccount.entity.Operation;

@Service
public class OperationPrinterImpl implements OperationPrinter {

	private final String HEADER = "DATE | AMOUNT | BALANCE";

	private PrintStream printStream;

	DecimalFormat decimaleFormat = new DecimalFormat("####.00");

	SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
	private static OperationPrinterImpl uniqueInstance;

	private OperationPrinterImpl() {

	}

	public static OperationPrinterImpl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new OperationPrinterImpl();
		}
		return uniqueInstance;
	}

	public void print(List<Operation> operations) {
		printHeader();
		LinkedList<String> formattedOperations = returnFromartedOperations(operations);
		printFormatedTransaction(formattedOperations);
	}

	private LinkedList<String> returnFromartedOperations(List<Operation> operations) {
		double balance = 0;
		LinkedList<String> formattedOperations = new LinkedList<String>();
		for (Operation operation : operations) {
			double amount = operation.getAmount();
			balance += operation.getAmount();
			formattedOperations.addFirst(dateFormater.format(operation.getDate()) + " | "
					+ decimaleFormat.format(amount) + " | " + decimaleFormat.format(balance));
		}
		return formattedOperations;
	}

	private void printFormatedTransaction(LinkedList<String> formattedTransactions) {
		for (String formattedTransaction : formattedTransactions) {
			this.printLine(formattedTransaction);
		}
	}

	private void printHeader() {
		printLine(HEADER);
	}

	public void printLine(String line) {
		printStream.println(line);
	}
}
