package spring.core.assignment3;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService{

	
	private BankAccountRepositoryImpl bankAccounts;

	
	public BankAccountRepositoryImpl getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(BankAccountRepositoryImpl bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	
	public double withdraw(long accountId, double balance) {
		boolean isDone = false;

		for(BankAccount account: bankAccounts.getBankAccountList()) {
			if(account.getAccountId() == accountId) {
				account.setAccountBalance(account.getAccountBalance()-(int)balance);
				isDone = true;
			}
		}
		if(isDone) {
			System.out.println("Withdraw successful");
		}
		else {
			System.out.println("No such Bank Account");
			return -1;
		}
		return bankAccounts.updateBalance(accountId, balance);	
	}

	public double deposit(long accountId, double balance) {
		boolean isDone = false;

		for(BankAccount account: bankAccounts.getBankAccountList()) {
			if(account.getAccountId() == accountId) {
				account.setAccountBalance(account.getAccountBalance()+(int)balance);
				isDone = true;
			}
		}
		if(isDone) {
			System.out.println("Deposit successful");
		}
		else {
			System.out.println("No such bank Account");
			return -1;
		}
		return bankAccounts.updateBalance(accountId, balance);	
	}

	public double getBalance(long accountId) {
		
		for(BankAccount account: bankAccounts.getBankAccountList()) {
			if(account.getAccountId() == accountId) {
				return account.getAccountBalance();
			}
		}
		
		return -1;
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) {
		BankAccount firstAccount = null;
		BankAccount secondAccount = null;
		boolean isDone1 = false;
		boolean isDone2 = false;
		for(BankAccount account: bankAccounts.getBankAccountList()) {
			if(account.getAccountId() == fromAccount) {
				firstAccount = account;
				isDone1 = true;
			}
			else if(account.getAccountId() == toAccount) {
				isDone2 = true;
				secondAccount = account;
			}
		}
		if(isDone1 == false || isDone2 == false) {
			return false;
		}
		else if(isDone1 && isDone2) {
			firstAccount.setAccountBalance(firstAccount.getAccountBalance()-(int)amount);
			if(firstAccount.getAccountBalance() < 0) {
				return false;
			}
			secondAccount.setAccountBalance(secondAccount.getAccountBalance()+(int)amount);
		}
	
		return true;
	}

	
	
}
