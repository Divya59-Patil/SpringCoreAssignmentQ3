package spring.core.assignment3;

public class BankAccountController {

	private BankAccountServiceImpl service;

	public BankAccountServiceImpl getService() {
		return service;
	}
	public void setService(BankAccountServiceImpl service) {
		this.service = service;
	}
	
	public double withdraw(long accountId, double balance) {
		return service.withdraw(accountId, balance);
	}
	public double deposit(long accountId, double balance) {
		return service.deposit(accountId, balance);
	}
	public double getBalance(long accountId) {
		return service.getBalance(accountId);
	}
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) {
		return service.fundTransfer(fromAccount, toAccount, amount);
	}
	
}

