package learnjava.course;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bank bank = new Bank("HSBC");

        bank.addBranch("Blackpool");

        bank.addCustomer("Blackpool", "Simon", 250.00);
        bank.addCustomer("Blackpool", "Rudi", 657.00);
        bank.addCustomer("Blackpool", "Lucy", 300.00);

        bank.addBranch("Cleveleys");
        bank.addCustomer("Cleveleys", "Keith", 123);

        bank.listCustomers("Blackpool", false);
        bank.listCustomers("Cleveleys", true);



    }

}
