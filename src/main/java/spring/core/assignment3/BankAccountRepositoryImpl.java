package spring.core.assignment3;

import java.util.List;

public class BankAccountRepositoryImpl implements BankAccountRepository {

	private List<BankAccount> bankAccountList;

	BankAccount bankAccount;

	// Autowired by constructor
	public BankAccountRepositoryImpl(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public List<BankAccount> getBankAccountList() {
		return bankAccountList;
	}

	public void setBankAccountList(List<BankAccount> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}

	public double getBalance(long accountId) {

		for (BankAccount account : bankAccountList) {
			if (account.getAccountId() == accountId) {
				return account.getAccountBalance();
			}
		}

		return -1;
	}

	public double updateBalance(long accountId, double newBalance) {
		return getBalance(accountId);
	}

}

