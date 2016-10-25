public class TestAccount {
   	public static void main(String[] args) {
    	// Test constructor and toString()
    	Account ac = new Account(5000, 1000);
    	System.out.println(ac);  // toString()
		System.out.println();
    	
    	// Test Setters and Getters
    	ac.setBalance(2000);
    	System.out.println(ac);  // run toString() to inspect the modified instance
    	System.out.println("Account Number is: " + ac.getAccountNumber());
    	System.out.println("Balance is: " + ac.getBalance());
    	System.out.println();

    	ac.debit(500.49);
    	System.out.println(ac);
    	System.out.println("Balance is " + ac.getBalance());
    	System.out.println();
    	
    	ac.credit(0.1);
    	System.out.println(ac);
    	System.out.println("Balance is " + ac.getBalance());
 		System.out.println();

        System.out.println(ac);  // toString()

        Account a = new Account(3000);
        System.out.println(a);	
    }
}
