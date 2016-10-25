/*
 * An Account class modeling a bank account
 * by Kyn Mark N. Trongcao
 */

public class Account {
	private int accountNumber;
	private double balance = 0.0;

	public Account(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		setBalance(balance);
	}

	public Account(double balance) {
		setBalance(balance);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("Invalid amount!");
		}
		this.balance = balance;		
	}

	public void credit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Invalid amount to credit!");
		}
		balance += amount;
	}

	public void debit(double amount) {
		if (balance < amount || amount <= 0) {
			throw new IllegalArgumentException("Invalid amount to debit!");
		}
		balance -= amount;
	}

	public String toString() {
		return String.format("A/C no: " + accountNumber + ", Balance = $%.2f", balance);
	}
}
