package bankaccount.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public class Operation {
	
	private Date date;
	private double amount;

	public Operation(Date date, double amount) {
		this.amount = amount;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}
