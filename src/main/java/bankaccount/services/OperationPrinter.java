
package bankaccount.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bankaccount.entity.Operation;

public interface OperationPrinter {

	void print(List<Operation> transactions);

	void printLine(String string);
	
	

}
