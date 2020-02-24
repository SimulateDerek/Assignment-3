
public class SavingsAccountTest {

	public static void main(String[] args) {

		SavingsAccounts saver1 = new SavingsAccounts();
		SavingsAccounts saver2 = new SavingsAccounts();
		
		saver1.setSavingsBalance(2000);
		saver2.setSavingsBalance(3000);
		
		saver1.modifyInterestRate(0.04);
		saver2.modifyInterestRate(0.04);
		

		for (int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.println("Saver 1 on month "+ (i+1) + " at 4%: " + saver1.getSavingsBalance());
			System.out.println("Saver 2 on month "+ (i+1) + " at 4%: " + saver2.getSavingsBalance());
		}
		
		System.out.println();
		
		saver1.modifyInterestRate(0.05);
		saver2.modifyInterestRate(0.05);

		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.println("Saver 1 after 1 month at 5%: " + saver1.getSavingsBalance());
		System.out.println("Saver 2 after 1 month at 5%: " + saver2.getSavingsBalance());

	}

}
