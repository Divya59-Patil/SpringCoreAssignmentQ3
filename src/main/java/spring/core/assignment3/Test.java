package spring.core.assignment3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("assignment3.xml");
		
		BankAccountController controller = (BankAccountController) context.getBean("controller");
		
		if(controller.withdraw(1, 5000) == -1) {
			System.out.println("Insufficient balance");
		}
		else {
			System.out.println("Balance of Account Id 1 is: " + controller.getBalance(1));
		}
		if(controller.deposit(1, 3000) == -1) {
			System.out.println("Invalid bank account Id");
		}
		else {
			System.out.println("Balance of Account Id 1 is: " +  controller.getBalance(1));
		}
		if(controller.fundTransfer(1, 2, 3000) == false) {
			System.out.println("Fund transfer failed");
		}
		else {
			System.out.println("Balance of Account Id 2 is: " + controller.getBalance(2));
		}
	}

}