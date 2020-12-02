package bankaccount.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import bankaccount.entity.Operation;

@Service
public class OperationRepositoryImpl implements OperationRepository {

	private List<Operation> listOperations;

	public OperationRepositoryImpl() {
		listOperations = new ArrayList<Operation>();
	}

	public void deposit(double amount) {
		addOperation(amount);
	}

	public void withdrawal(double amount) {
		addOperation(amount);
	}
	
	private void addOperation(double amount){
		Operation operation = new Operation(new Date(), amount);
		listOperations.add(operation);
	}

	public List<Operation> getAllOperations() {
		return listOperations;
	}

	@Override
	public double getBalance() {
		double solde = 0;
		if(listOperations!= null) {
		for(int i = 0; i<listOperations.size(); i++)
			 solde += listOperations.get(i).getAmount();
		}
		return solde;
	}

}
